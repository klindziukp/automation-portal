function run_animation() {
	$('.ml13').each(
			function() {
				$(this).html(
						$(this).text().replace(/([^\x00-\x01]|\w.*)/g,
								"<span class='letter'>$&</span>"));
			});

	anime.timeline({
		loop : true
	}).add({
		targets : '.ml13 .letter',
		translateY : [ 100, 0 ],
		translateZ : 0,
		opacity : [ 0, 1 ],
		easing : "easeOutExpo",
		duration : 1400,
		delay : function(el, i) {
			return 10 + 30 * i;
		}
	}).add({
		targets : '.ml13 .letter',
		translateY : [ 0, -100 ],
		opacity : [ 1, 0 ],
		easing : "easeInExpo",
		duration : 1200,
		delay : function(el, i) {
			return 60000 + 30 * i;
		}
	});
}
$(document).ready(run_animation);