$(document).ready(function() {
	setTimeout(function(){resize()}, 200);
	$(document).ajaxComplete(function(){resize()});
	$(document).ajaxError(function(){resize()});
	$("li[role='tab']").click(function(){resize()});
	$( window ).resize(function() {resize()});
});

function resize() {
  var screenHeight = $(window).height();
  if ($("#container").height() < screenHeight) {
	  $("#menu").height(screenHeight - $("#header").height() - $("#user_info").height() - $("#footer").height() - 40);
  }
}