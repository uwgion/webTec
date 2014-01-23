
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AngebotSuchen],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(suchForm: Form[AngebotSuchen]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.33*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("HoeriMit")/*6.18*/ {_display_(Seq[Any](format.raw/*6.20*/("""

"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = routes.AngeboteSuchen.angeboteSuchen)/*8.60*/ {_display_(Seq[Any](format.raw/*8.62*/("""
        <fieldset>
            <legend>Angebote suchen</legend>
            
            """),_display_(Seq[Any](/*12.14*/inputText(
                suchForm("startAdresse"), 
                '_label -> "Von", 
                '_error -> suchForm.error("startAdresseError")
            ))),format.raw/*16.14*/("""
            
            """),_display_(Seq[Any](/*18.14*/inputText(
                suchForm("zielAdresse"), 
                '_label -> "Nach",
                '_error -> suchForm.error("zielAdresseError")
            ))),format.raw/*22.14*/("""
          
        </fieldset>
        <div class="actions">
			 <input type="submit" class="btn btn-default" value="Angebote suchen" onclick="getAlert()">
			 """),_display_(Seq[Any](/*27.6*/if((request.cookies.get("sessionID") == null) && (session.get("sessionID") == null))/*27.90*/{_display_(Seq[Any](format.raw/*27.91*/("""
	         <a href=""""),_display_(Seq[Any](/*28.21*/routes/*28.27*/.Registration.showRegistrationForm)),format.raw/*28.61*/("""" class="btn">Noch nicht regestriert?</a>
	         """)))})),format.raw/*29.12*/("""
		</div>	  
		  		  
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANZ1Q7tCDs-DXRW3BRdUudw-X5AHVN3d4&sensor=false"></script>
    <script>
		function getAlert()"""),format.raw/*34.22*/("""{"""),format.raw/*34.23*/("""
			var geocoder = new google.maps.Geocoder();
		
			//alert("this is an alert " + google.maps.GeocoderStatus.OK);
		"""),format.raw/*38.3*/("""}"""),format.raw/*38.4*/("""
	</script>
    """)))})),format.raw/*40.6*/("""

  <!--<input id="startAdresse" type="text" placeholder="startAdresse"/>
		<input id="startKoordinaten" type="text" placeholder="startKoordinaten"/>
		<button id="getCoordinates2" onclick="codeAddress()">test button</button>
		  
		  
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANZ1Q7tCDs-DXRW3BRdUudw-X5AHVN3d4&sensor=false"></script>
    <script>

    var geocoder;
    var map;
    
    	function codeAddress() """),format.raw/*53.29*/("""{"""),format.raw/*53.30*/("""
    		geocoder = new google.maps.Geocoder();
    	
    	  var address = document.getElementById('startAdresse').value;
    	 
    	  geocoder.geocode( """),format.raw/*58.26*/("""{"""),format.raw/*58.27*/("""'address' : address"""),format.raw/*58.46*/("""}"""),format.raw/*58.47*/(""", function(results, status) """),format.raw/*58.75*/("""{"""),format.raw/*58.76*/("""  
   		  alert("2. Alert " + google.maps.GeocoderStatus.OK + " " + status);
    	    if (status == google.maps.GeocoderStatus.OK) """),format.raw/*60.55*/("""{"""),format.raw/*60.56*/("""
    	    	alert(results[0].geometry.location + "hallo")
    	    	// = "test";
    	    """),format.raw/*63.10*/("""}"""),format.raw/*63.11*/(""" else """),format.raw/*63.17*/("""{"""),format.raw/*63.18*/("""
    	      alert('Geocode was not successful for the following reason: ' + status);
    	    """),format.raw/*65.10*/("""}"""),format.raw/*65.11*/("""
    	  """),format.raw/*66.8*/("""}"""),format.raw/*66.9*/(""");
    	"""),format.raw/*67.6*/("""}"""),format.raw/*67.7*/("""</script>
    <div id="result"></div>	  -->  
""")))})),format.raw/*69.2*/("""
"""))}
    }
    
    def render(suchForm:Form[AngebotSuchen]): play.api.templates.HtmlFormat.Appendable = apply(suchForm)
    
    def f:((Form[AngebotSuchen]) => play.api.templates.HtmlFormat.Appendable) = (suchForm) => apply(suchForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jan 21 15:07:07 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/index.scala.html
                    HASH: dbb1b4ccfddf74590edde7d7955e1550e75b5fce
                    MATRIX: 787->1|962->32|990->85|1026->87|1050->103|1089->105|1126->108|1139->114|1199->166|1238->168|1365->259|1552->424|1615->451|1800->614|1997->776|2090->860|2129->861|2186->882|2201->888|2257->922|2342->975|2548->1153|2577->1154|2721->1271|2749->1272|2797->1289|3261->1725|3290->1726|3470->1878|3499->1879|3546->1898|3575->1899|3631->1927|3660->1928|3819->2059|3848->2060|3965->2149|3994->2150|4028->2156|4057->2157|4179->2251|4208->2252|4243->2260|4271->2261|4306->2269|4334->2270|4412->2317
                    LINES: 26->1|32->1|34->5|35->6|35->6|35->6|37->8|37->8|37->8|37->8|41->12|45->16|47->18|51->22|56->27|56->27|56->27|57->28|57->28|57->28|58->29|63->34|63->34|67->38|67->38|69->40|82->53|82->53|87->58|87->58|87->58|87->58|87->58|87->58|89->60|89->60|92->63|92->63|92->63|92->63|94->65|94->65|95->66|95->66|96->67|96->67|98->69
                    -- GENERATED --
                */
            