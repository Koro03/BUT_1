<?php
    $tablo = [];
    $files = glob("*.c"); 
    $config = file("config");
    foreach ($files as $file) {
        $fichier = file($file);    
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentation</title>
    <link rel="stylesheet" href="cssdocutilisateur.css">
</head>
<body>
    <header>
        <h1>Documentation technique</h1>
        <ul>
        <?php
            date_default_timezone_set('UTC');
            foreach ($config as $value) {
                if (preg_match("#CLIENT#",$value)) {
                    echo "<li><h3>$value</h3></li>";
                }elseif (preg_match("#PRODUIT#",$value)) {
                    echo "<li>$value</li>";
                }elseif (preg_match("#VERSION#",$value)) {
                    echo "<li>$value</li>";
                }
            }
            $today = date("m.d.Y");
            echo date("<li>$today</li>\n");
            foreach ($fichier as $value) {
                if (preg_match("#@brief#",$value)) {
                    echo "\n<li>descrition brève du code : $value</li>";
                }
            }
        ?>
        </ul>
    </header>
    <main>
    <h3>DEFINE</h3>
    <div>
<?php
        
    foreach ($fichier as $value) { 
        if (preg_match("#define#", $value)) {
            $position = strpos($value, '/**');
            $value = ($position !== false) ? substr($value, 0, $position): $value;
            echo "<p>$value</p>\n";
        }
    }
?>
    </div>
    <div>
    <h3>STRUCTURE</h3>
<?php
    $inStruct = false;
    foreach ($fichier as $value) {
        if (preg_match("#struct#", $value)) {
            $inStruct = true;
        }if ($inStruct) {
            echo "<p>       $value</p>\n";
        }if (preg_match( "#}#" ,$value)) {
            $inStruct = false;
        }  
    }
?>
    </div>
    <div>
    <h3>GLOBALES</h3>
<?php
    $inMain = false;
    foreach ($fichier as $value) {
        if ((preg_match("#main()#", $value))){
            $inMain = true;
        }
        if ($inMain && ((preg_match("#int#",$value) || preg_match("#char#",$value) || preg_match("#bool#",$value)) && preg_match("%; /\*\*\w+%", $value))) {
            $position = strpos($value, '/**');
            $value = ($position !== false) ? substr($value, 0, $position): $value;
            echo "<p>$value</p>\n";
        }
        if (preg_match("#const#", $value)) {
            echo "<p>$value</p>";
        }
        if (strpos($value, "EXIT_SUCCESS") == true) {
            $inMain = false;
        }
    }
?>
    </div>
    <div>
    <h3>FONCTIONS</h3>
<?php
    foreach ($fichier as $value) {
        if (preg_match("%fn%",$value)) {
            echo "<p>$value</p>\n";
        }
        elseif (preg_match("#details#",$value)) {
            echo "<p>description : $value</p>\n";
        }
        elseif (preg_match("#param#",$value)) {
            echo "<p>parametre : $value</p>\n";
        }
        elseif (preg_match("#@return#",$value)) {
            echo "<p>retourne :$value</p>\n";
        }  
    }
}
?>
    </div>
    </main>
</body>
</html>
