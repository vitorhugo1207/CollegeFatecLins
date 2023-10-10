<?php 

if(isset($_GET['parametros'])){
    $parametros = $_GET['parametros']; // variable
    echo $parametros;
} else {
    echo "Sem parametros";
}

?>