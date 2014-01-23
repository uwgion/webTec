
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object _displaySearchOffer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Geocoding service</title>
    <style>
      html, body, #map-canvas """),format.raw/*8.31*/("""{"""),format.raw/*8.32*/("""
        height: 100%;
        margin: 0px;
        padding: 0px
      """),format.raw/*12.7*/("""}"""),format.raw/*12.8*/("""
      #panel """),format.raw/*13.14*/("""{"""),format.raw/*13.15*/("""
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      """),format.raw/*22.7*/("""}"""),format.raw/*22.8*/("""
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
var geocoder;
var map;
function initialize() """),format.raw/*28.23*/("""{"""),format.raw/*28.24*/("""
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(-34.397, 150.644);
  var mapOptions = """),format.raw/*31.20*/("""{"""),format.raw/*31.21*/("""
    zoom: 8,
    center: latlng
  """),format.raw/*34.3*/("""}"""),format.raw/*34.4*/("""
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/("""

function codeAddress() """),format.raw/*38.24*/("""{"""),format.raw/*38.25*/("""
  var address = document.getElementById('address').value;
  geocoder.geocode( """),format.raw/*40.21*/("""{"""),format.raw/*40.22*/(""" 'address': address"""),format.raw/*40.41*/("""}"""),format.raw/*40.42*/(""", function(results, status) """),format.raw/*40.70*/("""{"""),format.raw/*40.71*/("""
    if (status == google.maps.GeocoderStatus.OK) """),format.raw/*41.50*/("""{"""),format.raw/*41.51*/("""
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker("""),format.raw/*43.43*/("""{"""),format.raw/*43.44*/("""
          map: map,
          position: results[0].geometry.location
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/(""");
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""" else """),format.raw/*47.12*/("""{"""),format.raw/*47.13*/("""
      alert('Geocode was not successful for the following reason: ' + status);
    """),format.raw/*49.5*/("""}"""),format.raw/*49.6*/("""
  """),format.raw/*50.3*/("""}"""),format.raw/*50.4*/(""");
"""),format.raw/*51.1*/("""}"""),format.raw/*51.2*/("""

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
    <div id="panel">
      <input id="address" type="textbox" value="Sydney, NSW">
      <input type="button" value="Geocode" onclick="codeAddress()">
    </div>
    <div id="map-canvas"></div>
  </body>
</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 17 20:54:34 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/_displaySearchOffer.scala.html
                    HASH: e115a55adbd3981a76fecd2668e9965cf4d9f781
                    MATRIX: 869->0|1114->218|1142->219|1244->294|1272->295|1315->310|1344->311|1587->527|1615->528|1810->695|1839->696|1988->817|2017->818|2082->856|2110->857|2220->940|2248->941|2303->968|2332->969|2441->1050|2470->1051|2517->1070|2546->1071|2602->1099|2631->1100|2710->1151|2739->1152|2863->1248|2892->1249|2998->1328|3026->1329|3061->1337|3089->1338|3123->1344|3152->1345|3265->1431|3293->1432|3324->1436|3352->1437|3383->1441|3411->1442
                    LINES: 29->1|36->8|36->8|40->12|40->12|41->13|41->13|50->22|50->22|56->28|56->28|59->31|59->31|62->34|62->34|64->36|64->36|66->38|66->38|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|71->43|71->43|74->46|74->46|75->47|75->47|75->47|75->47|77->49|77->49|78->50|78->50|79->51|79->51
                    -- GENERATED --
                */
            