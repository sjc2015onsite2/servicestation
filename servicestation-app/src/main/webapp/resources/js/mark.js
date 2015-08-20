$(pct).on("input focus change", function(){
	$(stars).removeClass().addClass("rating-"+$(pct).val());
});