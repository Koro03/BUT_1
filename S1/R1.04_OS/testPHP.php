<?php
$str = "*de type structure STRUCTURE* ";
$str1 = "**de type structure STRUCTURE   c-               ";
$str2 = "-de type structure STRUCTURE   5-*         ";
$structure = "/### STRUCTURE/";
$fonction = "/### FONCTION/";
$finStructure = "/\*\s*$/";
$entrer_et_sortie = "/^\*\*/";
$marqueur_tiret = "/^-/";

$define = "/^\| Define/";
$DEFINE = "/^\|DEFINE/";


$tab_Lignes_fichiers = [];
$fichier = file('C:\Users\benfa\Documents\Iut_1a\SAE_Docker\sae103_c13\DOCU_UTILISATEUR.md',FILE_IGNORE_NEW_LINES);
$afficher = false;
echo preg_match($structure, $str);
foreach ($fichier as $ligne) {
    if (preg_match($DEFINE,$ligne) == 1 || preg_match($define,$ligne) == 1) {
        $afficher = true;
    }
    if ($afficher == true) {
        echo $ligne;
    }
    if (preg_match("/\|/",$ligne)) {
        $afficher = false;
    }
    
}

?>
***************************************

//cherche la position du pattern et le supprime
<?php
// Chaîne de caractères
$chaine = "Ceci est un exemple jusqu'à un certain caractère.";

// Caractère jusqu'auquel afficher
$caractereLimite = "'";

// Trouver la position du caractère limite
$position = strpos($chaine, $caractereLimite);

// Extraire la sous-chaîne jusqu'à la position du caractère limite
if ($position !== false) {
    $mots = substr($chaine, 0, $position + 1);
    echo $mots;
} else {
    echo "Le caractère limite n'a pas été trouvé dans la chaîne.";
}
?>
<?php
    foreach ($fichier as $ligne) {
        if (preg_match($DEFINE,$ligne) == 1 || preg_match($define,$ligne) == 1) {
            $afficher = true;
        }
        if ($afficher == true) {
            echo $ligne;
        }
        if (preg_match("/\|/",$ligne)) {
            $afficher = false;
        }
        
    }

?>
<?php
    $tab_Lignes_fichiers = [];
    $fichier = file('DOCU_UTILISATEUR.md');
    $afficher = false;
    //Les différents pattern à retrouver dans les lignes
    $structure = "/### STRUCTURE/";
    $fonction = "/### FONCTION/";
    $procedure = "/### PROCÉDURE/";
    $descriptionProgDeb = "/^\*/";
    $descriptionProgFin = "/\*\s*$/";
    $entrer_et_sortie = "/^\*\*/";
    $marqueur_tiret = "/^-/";
    $information = "/^## INFORMATION/";
     
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>DOCUMENTATION UTILISATEUR</title>
        <link rel="stylesheet" href="cssdocutilisateur.css">
    </head>
    <body>
        <header>
            <h1>DOCUMENTATION UTILISATEUR</h1>
            <h2>information</h2>
            <ul>
                <li>Nom_fichier</li>  
                <li>auteur</li>
                <li>date</li>
                <li>descrition_brève_du_code</li>
            </ul>
        </header>
        <main>
            <p>
                <?php
                    $tab_Lignes_fichiers = [];
                    $fichier = file('DOCU_UTILISATEUR.md');
                    $afficher = false; 
                    foreach ($fichier as $ligne) {
                        if (preg_match($descriptionProgDeb, $ligne ) == 1 &&  preg_match($entrer_et_sortie,$ligne) !=1) {
                            $afficher = true; 
                        }                  
                        if ($afficher == true){
                            echo "<em>$ligne</em>" ;
                        }
                        if (preg_match($descriptionProgFin, $ligne) == 1){
                            $afficher = false;
                        }
                    }
                ?>
            </p>
            <table>
                <tr>
                    
                  <th>DEFINE</th>
                  <th>Valeur</th>
                  <th>Commentaire</th>
                </tr>
                            <?php
                                $tab_Lignes_fichiers = [];
                                $fichier = file('DOCU_UTILISATEUR.md');  
                                $caractereLimitePipe =  "|"; ; 
                                $finCommentaire = "";
                                $commentaire = "";
                                $i = 4; 
                                $DEFINE = "/^\|DEFINE/";                         
                                foreach ($fichier as $ligne) { 
                                    $positionPipe = strpos($ligne,$caractereLimitePipe);          
                                    if(preg_match("/^\|/",$ligne) == 1 && preg_match($DEFINE,$ligne) != 1 && preg_match("/^\|-/", $ligne) !=1 ){
                                        $afficher = true;            
                                    }  
                                    if ($afficher == true){
                                        $ligneSansPipe = str_replace("|", "", $ligne);
                                        $elements = explode(" ", trim($ligneSansPipe));
                                        $define = isset($elements[0]) ? $elements[0] : '';
                                        
                                        $val = isset($elements[2]) ? $elements[2] : '';
                                        while ($i <= count($elements)) {
                                            $finCommentaire = $finCommentaire . " " . $commentaire;
                                            $commentaire = isset($elements[$i]) ? $elements[$i] : '';

                                            $i = $i + 1;
                                            
                                        }
                                        echo "<tr><td>$define</td><td>$val</td> <td>$finCommentaire</td><tr>";  
                                    }
                                    if (preg_match("/^\s/",$ligne) == 1) {
                                        $afficher = false;
                                    }               
                                    
                                }
                            ?>
                <tr>
                  <td>Define1</td>
                  <td>Val1</td>
                  <td>commentaire qui décris le define</td>
                </tr>
                <tr>
                  <td>Define2</td>
                  <td>Val2</td>
                  <td>commentaire qui décris le define</td>
                </tr>
                <tr>
                  <td>Define3</td>
                  <td>Val3</td>
                  <td>commentaire qui décris le define</td>
                </tr>
                <tr>
                  <td>Define4</td>
                  <td>Val4</td>
                  <td>commentaire qui décris le define</td>
                </tr>
            
              </table>
              <article>
                <h3>STRUCTURE</h3>
                    <ul>
                        <?php
                            $tab_Lignes_fichiers = [];
                            $fichier = file('DOCU_UTILISATEUR.md');
                            $afficher = false;
                            $caractereLimite = "###"; 
                            $caractereLimiteTiret = "-";
                            
                            foreach ($fichier as $ligne) {
                                $position = strpos($ligne, $caractereLimite);
                                $positionTiret = strpos($ligne, $caractereLimiteTiret);
                                if (preg_match($structure, $ligne ) == 1 ) {
                                    $afficher = true; 
                                }                  
                                if ($afficher == true){
                                    if ($positionTiret !== false) {
                                        $ligne = substr($ligne,2, $positionTiret + 20);
                                        echo "<li>$ligne</li><br>";
                                    }
                                    
                                }
                                if (preg_match("/^\s/", $ligne) == 1){
                                    $afficher = false;
                                }
                            }
                        ?>
                    </ul>
                    <h3>FONCTION</h3>
                            <?php
                                $tab_Lignes_fichiers = [];
                                $fichier = file('DOCU_UTILISATEUR.md');
                                $afficher = false; 
                                $caractereLimite = "####";
                                $caractereLimiteEtoile = "**";
                                $caractereLimitePoint = ":";
                                $caractereLimiteEtoileFin = "/:\**/";
                                foreach ($fichier as $ligne) { 
                                    $position = strpos($ligne, $caractereLimite);
                                    $positionPoint = strpos($ligne, $caractereLimitePoint); 
                                    $positionEtoile = strpos($ligne, $caractereLimiteEtoile); 
                                    $positionEtoileFin = strpos($ligne, ":**");                   
                                    if(preg_match("/^####/",$ligne) == 1 && preg_match("/procédure/",$ligne) != 1){
                                        $afficher = true;            
                                    }  
                                    if ($afficher == true){
                                        if ($position !== false) {
                                            $mots = substr($ligne,5, $positionPoint -3 );
                                            $PositionMots = strpos($ligne, $mots);
                                            $ligne = substr($ligne,33, $PositionMots + 100 );
                                            echo "<p><strong>$mots</strong>$ligne<p>";                                            
                                        }
                                        if ($positionEtoileFin !== false) {
                                            $nouvMots = substr($ligne,$positionEtoileFin +3 );
                                        }
                                        if ($positionEtoile !== false ) {
                                            $mots = substr($ligne,2, $positionEtoile + 8 );
                                            
                                            echo "<p><strong>$mots</strong>$nouvMots</p>";
                                        }   
                                    }
                                    if (preg_match("/^\s/",$ligne) == 1) {
                                        $afficher = false;
                                    }               
                                    
                                }
                            ?>
                    <h3>PROCÉDURE</h3>
                            <?php
                                $tab_Lignes_fichiers = [];
                                $fichier = file('DOCU_UTILISATEUR.md');
                                $afficher = false; 
                                $caractereLimite = "####";
                                $caractereLimiteEtoile = "**";
                                $caractereLimitePoint = ":";
                                $caractereLimiteEtoileFin = "/:\**/";
                                foreach ($fichier as $ligne) { 
                                    $position = strpos($ligne, $caractereLimite);
                                    $positionPoint = strpos($ligne, $caractereLimitePoint); 
                                    $positionEtoile = strpos($ligne, $caractereLimiteEtoile); 
                                    $positionEtoileFin = strpos($ligne, ":**");                   
                                    if(preg_match("/^####/",$ligne) == 1 && preg_match("/fonction/",$ligne) != 1){
                                        $afficher = true;            
                                    }  
                                    if ($afficher == true){
                                        if ($position !== false) {
                                            $mots = substr($ligne,5, $positionPoint -3 );
                                            $PositionMots = strpos($ligne, $mots);
                                            $ligne = substr($ligne,33, $PositionMots + 100 );
                                            echo "<p><strong>$mots</strong>$ligne<p>";                                            
                                        }
                                        if ($positionEtoileFin !== false) {
                                            $nouvMots = substr($ligne,$positionEtoileFin +3 );
                                        }
                                        if ($positionEtoile !== false ) {
                                            $mots = substr($ligne,2, $positionEtoile + 8 );
                                            
                                            echo "<p><strong>$mots</strong>$nouvMots</p>";
                                        }   
                                    }
                                    if (preg_match("/^\s/",$ligne) == 1) {
                                        $afficher = false;
                                    }               
                                    
                                }
                            ?>
                </article>
        </main> 
    </body> 
</html>