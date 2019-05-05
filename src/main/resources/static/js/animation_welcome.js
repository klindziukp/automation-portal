function run_animation() {
	$('.ml3welcome').each(function() {
		$(this).html(
				$(this).text().replace(/([^\x00-\x01]|\w.*)/g,
						"<span class='letter'>$&</span>"));
	});

	anime.timeline({
		loop : true
	}).add({
		targets : '.ml3welcome .letter',
		opacity : [ 0, 1 ],
		easing : "easeInOutQuad",
		duration : 2250,
		delay : function(el, i) {
			return 30 * (i + 1)
		}
	}).add({
		targets : '.ml3welcome',
		opacity : 0,
		duration : 1000,
		easing : "easeOutExpo",
		delay : 5000
	});
}
$(document).ready(run_animation);