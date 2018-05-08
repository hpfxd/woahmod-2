$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases", function(data) {
        data.reverse();
        $.each(data, function (i, v) {
            var ver = v.tag_name;
            $("#releases-section").append(
                "<div>" +
                "<b>" + v.name + "</b>" + (v.prerelease ? "<i>PRERELEASE</i>" : "") +
                "<a class='btn' target='_blank' href='https://github.com/hpfxd/woahmod-2/releases/download/" + ver + "/woahmod-2-" + ver + ".jar'>Download v" + ver + "</a>" +
                "</div>"
            );
        });
    });
});
