<?php
$servername = "localhost";
$username = "rfwuryzg_samUN";
$password = "xVt2TByc7";
$dbName = "rfwuryzg_sameatDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbName);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";

?>