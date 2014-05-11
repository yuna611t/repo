<?php
$string = "start";
$value = $_REQUEST['search_term'];
if($value ==="a"){
$string .= "aaaaa";
}else{
$string .="bbbb";
}

echo $string;
?>