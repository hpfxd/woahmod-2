$(document).ready(function() {
    $.getJSON("https://api.github.com/repos/hpfxd/woahmod-2/releases/latest", function(data) {
        var ver = data.tag_name;
        var count = new countUp("latest", 0.0, ver, 1, 3, {
            prefix: "v",
            decimal: ".",
            useEasing: true,
            useGrouping: true,
            separator: ","
        });
        if (!count.error) {
            count.start();
        } else {
            console.error(count.error);
        }
    });
});
