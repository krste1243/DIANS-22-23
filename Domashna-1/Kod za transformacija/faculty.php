<?php
$faculties=file_get_contents("faculty.json");
$faculties_arr=json_decode($faculties,true);
$faculties_map=array_map(function($faculty){
    return [
        $faculty['place_id'],
        $faculty['display_name'],
        $faculty['lat'],
        $faculty['lon']
    ];
}, $faculties_arr);


$file = fopen('faculties_info.csv', 'w');

fputcsv($file, ['place_id', 'display_name', 'lat', 'lon']);

foreach ($faculties_map as $row) {
    fputcsv($file, $row);
}

fclose($file);