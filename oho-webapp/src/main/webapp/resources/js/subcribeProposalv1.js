function updateProposalForm() {
	$('#cmdRerenderForm').click();
	return false;
};

$(document).ready(function(){
    $('#nonAjaxLoad').hide();
});

var clMask;

$(window).bind('beforeunload', function() {
    $('#nonAjaxLoad').show(); 
    if (clMask != undefined && clMask != null) {
        clearTimeout(clMask);
    };
    clMask = setTimeout(function() {
        $('#nonAjaxLoad').hide();
    }, 2000);
});
