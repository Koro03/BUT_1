<?php
    function afficheHello() {
        echo "HelloWorld";

    }
    afficheHello();
    function dump (){
        $var = 5;
        var_dump($var);
    }
    dump();
    $GLOBALS['varCalc'] = 8;
    function addVarGlob() {
        $GLOBALS['varCalc'] = $GLOBALS['varCalc']*2;
        echo $GLOBALS['varCalc'];
    }
    addVarGlob();
    function Tab()  {
        $tab = [1,2,3,5,8];
        foreach ($tab as $val ) {
            if ($val == 2 or $val == 8 ) {
                echo "En sah bg";
            }
        } 
    }
    Tab();
    

?>
<!DOCTYPE html>
<html>
    <title>jsp</title>
    <body>
        <?php
            echo "<h1> balou </h1>";
            echo "<br>";
            dump();
            echo "<br>";
            afficheHello();

        ?>
    </body>
</html>

