$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases", function(data) {
        $.each(data, function (i, v) {
            var ver = v.tag_name;
            $("#releases-section").append(
                "<div>" +
                "<p><b>" + v.name + "</b> " + (v.prerelease ? "<i>PRE-RELEASE</i>" : "<i>RELEASE</i>") + "</p> " +
                "<p><a style='text-decoration:none;' target='_blank' href='https://github.com/hpfxd/woahmod-2/releases/download/" + ver + "/woahmod-2-" + ver + ".jar'>Download woahmod-2-" + ver + ".jar</a></p>" +
                "<p>    <a style='text-decoration:none;' target='_blank' href='https://github.com/hpfxd/woahmod-2/archive/0.7.zip'>Download " + ver + ".zip</a> (source code)</p>" +
                "<p>    <a style='text-decoration:none;' target='_blank' href='https://github.com/hpfxd/woahmod-2/archive/0.7.tar.gz'>Download " + ver + ".tar.gz</a> (source code)</p>" +
                "</div>"
            );
        });
    });
});
