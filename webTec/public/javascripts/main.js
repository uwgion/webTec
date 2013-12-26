$(document).ready(function(){

        var url = window.location;
         $('ul.nav a').filter(function() {
            return this.href == url;
        }).parent().removeClass('active');
        // Will also work for relative and absolute hrefs
        $('ul.nav a').filter(function() {
            return this.href == url;
        }).parent().addClass('active');
});
