$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases/latest", function(data) {
        var ver = data.tag_name;
        var count = new countUp("latest", 0.0, ver, 1);
        if (!count.error) {
            count.start();
        } else {
            console.error(count.error);
        }

        $(".page-header").append("<a class='btn'" +
            " href='https://github.com/hpfxd/woahmod-2/releases/download/"+ver+"/woahmod-2-"+ver+".jar'" +
            " target='_blank'>" +
            "Download" +
            "</a>");
    });
});