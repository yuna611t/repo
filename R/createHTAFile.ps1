$ext01=".html"
$ext02=".hta"
$filelist=@("sample1","sample2_1","sample3","sample4_1","sample5","sample6","sample7","sample8")

foreach ($file in $filelist) {
    $file01 = $file + $ext01
    $file02 = $file + $ext02
    copy $file01 $file02
}