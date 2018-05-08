$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases/latest", function(data) {
        var count = new countUp("latest", 0.0, 0.7, 1);
        if (!count.error) {
            count.start();
        } else {
            console.error(count.error);
        }
    });
});