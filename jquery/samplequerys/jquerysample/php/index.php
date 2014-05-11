<html>
<head>
<meta charset="UTF-8" />
<title>imagelist</title>
<script type="text/javascript" src="../../js/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#search_results").slideUp();
	$("#search_button").click(function(e){
		e.preventDefault();
		ajax_search();
	});
	$("#search_term").keyup(function(e){
		e.preventDefault();
		ajax_search();
	});
});

function ajax_search(){
	$("#search_results").show();
	var search_val=("#search_term").val();
	$.post("./find.php",{search_term:search_val},function(data{
		$("#search_results").html(data);
	});
}
</script>
</head>
<body>
<form id="search_term" method="post">
<div>
	<label for="search_term">Search name/phone</label>
	<input type="text" name="search_term" id="search_term" />
	<input type="button" value="search" id="search_button" />
</div>
</form>
<div id="search_results"></div>
</body>
</html>