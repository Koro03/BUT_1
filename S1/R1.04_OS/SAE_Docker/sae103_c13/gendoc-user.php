<?php
function version($config) {
    $debut = strpos($config, 'VERSION=');
    $fin = strpos($config, "\n", $debut);
    $version = substr($config, $debut + strlen('VERSION='), $fin - $debut - strlen('VERSION='));
    return trim($version);
}

function projet($config) {
    $debut = strpos($config, 'PRODUIT=');
    $fin = strpos($config, "\n", $debut);
    $projet = substr($config, $debut + strlen('PRODUIT='), $fin - $debut - strlen('PRODUIT='));
    return trim($projet);
}

function client($config) {
    $debut = strpos($config, 'CLIENT=');
    $fin = strpos($config, "\n", $debut);
    $client = substr($config, $debut + strlen('CLIENT='), $fin - $debut - strlen('CLIENT='));
    return trim($client);
}

$config = file_get_contents('config');
$version = version($config);
$projet = projet($config);
$client = client($config);

$elemArecup = glob('*.md');
$elemArecup = file_get_contents($elemArecup[0]);
$html = ConvertirEnHTML($elemArecup);

function ConvertirEnHTML($elemArecup)
{
    $elemArecup = preg_replace('/^#\s?([^#].+)$/m', '<h1>$1</h1>', $elemArecup);
    $elemArecup = preg_replace('/^##\s?([^#].+)$/m', '<h2>$1</h2>', $elemArecup);
    $elemArecup = preg_replace('/^###\s?([^#].+)$/m', '<h3>$1</h3>', $elemArecup);
    $elemArecup = preg_replace('/^####\s?([^#].+)$/m', '<h4>$1</h4>', $elemArecup);
    $elemArecup = preg_replace('/^#####\s?([^#].+)$/m', '<h5>$1</h5>', $elemArecup);
    $elemArecup = preg_replace('/\*\*(.+)\*\*/', '<strong>$1</strong>', $elemArecup);
    $elemArecup = preg_replace('/_(.+)_/', '<em>$1</em>', $elemArecup);


    
    for ($i = 0; $i < 500; $i++) {    
        $elemArecup = preg_replace('/^[*-]\s*(.+)$/m', '<ul><li>$1</li></ul>', $elemArecup);
    }
    for ($i = 0; $i < 500; $i++) {    
        $elemArecup = preg_replace('/^(\d+)\.\s*(.+)$/m', '<li>$2</li>', $elemArecup);
    }

    $elemArecup = preg_replace('/!\[(.+)\]\s?\((.+)\)/', '<img src="$2" alt="$1" />', $elemArecup);
    $elemArecup = preg_replace('/\[(.+)\]\s?\((.+)\)/', '<a href="$2">$1</a>', $elemArecup);
    $elemArecup = preg_replace('/~~(.+)~~/', '<del>$1</del>', $elemArecup);
    $elemArecup = preg_replace_callback('/```(.*?)```/s', function ($matches) {
        return '<pre>' . trim($matches[1]) . '</pre>';
    }, $elemArecup);

    $elemArecup = preg_replace('/\n>(.+)/', '<blockquote>$1</blockquote>', $elemArecup);
    $elemArecup = preg_replace('/\n---/', '<hr/>', $elemArecup);
    $elemArecup = preg_replace('/\n/', '<br/>', $elemArecup);
    

    $elemArecup = preg_replace_callback('/\n\|(.+)\|/', function ($matches) {
        $ligne = $matches[1];
        $ligne = preg_replace('/\|/', '</td><td>', $ligne);
        return '<tr><td>' . $ligne . '</td></tr>';
    }, $elemArecup);

    
    $elemArecup = preg_replace('/^\|(.*)/', '<tr>$1</tr>', $elemArecup);
    $elemArecup = preg_replace('/(.+)/', '<p>$1</p>', $elemArecup);

    return $elemArecup;
}

ob_start();
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentation Utilisateur - Version <?php echo $version ?></title>
    <link rel="stylesheet" href="cssdocutilisateur.css">
</head>
<body>
    <header>
        <h1>Documentation Utilisateur - Version <?php echo $version ?></h1>
        <h2><?php echo $projet ?></h2>
        <h3><?php echo $client ?></h3>
    </header>
    <main>
        <?php echo $html ?>
    </main>
</body>
</html>

<?php
$html = ob_get_clean();
file_put_contents('doc-user-' . $version . '.html', $html);
?>