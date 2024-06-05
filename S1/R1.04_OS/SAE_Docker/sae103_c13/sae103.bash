#!/bin/bash

is_major=0
is_minor=0
is_build=0

# 1 seul paramètre ?
if [ $# -ne 1 ]; then
    >&2 echo "ERREUR. Un seul paramètre est requis."
    >&2 echo "$0 --[major|minor|build]"
    exit 1
elif [ "$1" == "--major" ]; then
    is_major=1
elif [ "$1" == "--minor" ]; then
    is_minor=1
elif [ "$1" == "--build" ]; then
    is_build=1
else
    >&2 echo "ERREUR. Paramètre non valide."
    >&2 echo "$0 --[major|minor|build]"
    exit 1
fi

# fichier config +
source config

# Extraire le nom du client
tmps="$CLIENT"
nom_client=$(tr " " "_" <<< "$tmps")

# Extraire les numéros de version
IFS='.' read -r -a version_array <<< "$VERSION"

# Afficher les numéros de version
major=${version_array[0]}
minor=${version_array[1]}
build=${version_array[2]}

# Mettre à jour les numéros de version
if [ $is_major -eq 1 ]; then
    major=$((major+1))
    minor=0
    build=0
elif [ $is_minor -eq 1 ]; then
    minor=$((minor+1))
    build=0
elif [ $is_build -eq 1 ]; then
    build=$((build+1))
fi

# Créer la version finale
version_finale="${major}.${minor}.${build}"

# Mettre à jour le fichier de configuration avec la nouvelle version
sed -i "s/VERSION=.*/VERSION=$version_finale/" config

# Lancer le conteneur clock en mode détaché
docker run -d --rm --name sae103-forever -v sae103:/work clock

# Copier les fichiers sources dans le conteneur
# sa fonctionne à coup sûr de prendre fichier par fichier mais tous les fichiers ça fonctionne pas correctement

#docker cp ./src1.c sae103-forever:/work
#docker cp ./src2.c sae103-forever:/work
#docker cp ./src3.c sae103-forever:/work
#docker cp ./gendoc-tech.php sae103-forever:/work
#docker cp ./gendoc-user.php sae103-forever:/work
#docker cp ./doc.md sae103-forever:/work
#docker cp ./cssdocutilisateur.css sae103-forever:/work

docker cp ./*.c sae103-forever:/work
docker cp ./*.php sae103-forever:/work
docker cp ./*.md sae103-forever:/work
docker cp ./*.css sae103-forever:/work

# Générer les documents HTML
echo "Conteneur PHP en cours d'exécution..."
docker run --rm -v sae103:/work -ti sae103-php php -f /work/gendoc-user.php > doc-user-${version_finale}.html
docker run --rm -v sae103:/work -ti sae103-php php -f /work/gendoc-tech.php > doc-tech-${version_finale}.html

# Copier les documents HTML dans le conteneur
docker container cp doc-user-${version_finale}.html sae103-forever:/work
docker container cp doc-tech-${version_finale}.html sae103-forever:/work

# Générer les documents PDF
echo "Conteneur html2pdf en cours d'exécution..."
docker run --rm -ti -v sae103:/work sae103-html2pdf "html2pdf doc-tech-${version_finale}.html doc-tech-${version_finale}.pdf"
docker run --rm -ti -v sae103:/work sae103-html2pdf "html2pdf doc-user-${version_finale}.html doc-user-${version_finale}.pdf"

# Copier les documents PDF depuis le conteneur
docker container cp sae103-forever:/work/doc-tech-${version_finale}.pdf ./
docker container cp sae103-forever:/work/doc-user-${version_finale}.pdf ./

# Créer une archive tar.gz contenant les fichiers PDF
tar czvf archive_doc_user_et_tech.tar.gz doc-tech-${version_finale}.pdf doc-user-${version_finale}.pdf

# Copier l'archive depuis le conteneur
docker container cp sae103-forever:/work/archive_doc_user_et_tech.tar.gz ./

# Lister le contenu de l'archive tar.gz
tar tzvf archive_doc_user_et_tech.tar.gz

# Arrêter le conteneur
docker stop sae103-forever

# Supprimer le volume Docker
docker volume rm sae103

