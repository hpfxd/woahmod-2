$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases/latest", function(data) {
        $("#latest").text(data.tag_name);
    });
});