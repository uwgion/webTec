
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
object angebotErstellen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Route],HashMap[String, String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(angebotForm: Form[Route])(fixedPoints: HashMap[String, String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.66*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("HöriMit")/*6.17*/ {_display_(Seq[Any](format.raw/*6.19*/("""
<div class="starter-template">
    <h1>Angebot erstellen</h1>
</div>
	<div class="row">
		     """),_display_(Seq[Any](/*11.9*/helper/*11.15*/.form(action = routes.Angebote.createRoute, 'class -> "col-md-8 form-group")/*11.91*/ {_display_(Seq[Any](format.raw/*11.93*/("""
		       
		        <fieldset>
		            <legend>Angebotdetails</legend>
		            """),_display_(Seq[Any](/*15.16*/inputText(
		                angebotForm("startAdresseForm"), 
		                'placeholder -> "Bitte eine Zieladresse eingeben.",
		                'class -> "form-control",
		                '_label -> "Startadresse", 
		                '_error -> angebotForm.error("startAdresse"),
		                '_help -> "",
		                '_class -> "col-md-6"
		            ))),format.raw/*23.16*/("""
		            """),_display_(Seq[Any](/*24.16*/select(
						angebotForm("startAdresseFormSelect"),
						options = options(fixedPoints),
						'class -> "form-control",				
						'_label -> "Von",
	                	'_default -> "Bitte ausw�hlen.",
		                '_class -> "col-md-6"
					))),format.raw/*31.7*/("""
					<div id="wegpunkte"></div>
		            
		            """),_display_(Seq[Any](/*34.16*/inputText(
		                angebotForm("zielAdresseForm"), 
		                'placeholder -> "Bitte eine Startadresse eingeben.",
		                'class -> "form-control",
		                '_label -> "Zieladresse", 
		                '_error -> angebotForm.error("zielAdresse"),
		                '_help -> "",
		                '_class -> "col-md-6"
		            ))),format.raw/*42.16*/("""
		            
		           	"""),_display_(Seq[Any](/*44.16*/select(
						angebotForm("zielAdresseFormSelect"),
						options = options(fixedPoints),
						'class -> "form-control",				
						'_label -> "Nach",
	                	'_default -> "Bitte ausw�hlen.",
		                '_class -> "col-md-6"
					))),format.raw/*51.7*/("""
					
		            """),_display_(Seq[Any](/*53.16*/inputText(
		                angebotForm("timeForm"), 
		                'placeholder -> "Bitte eine Uhrzeit eingeben im Format hh:mm",
		                'class -> "form-control",
		                '_label -> "Zeit", 
		                '_error -> angebotForm.error("zeit"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*61.16*/("""
		            """),_display_(Seq[Any](/*62.16*/inputDate(
		                angebotForm("dateForm"), 
		                'placeholder -> "Bitte ein Datum eingeben im Format tt.mm.yyyy",
		                'class -> "form-control",
		                '_label -> "Datum", 
		                '_error -> angebotForm.error("datum"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*70.16*/("""
		            """),_display_(Seq[Any](/*71.16*/inputText(
		                angebotForm("seats"), 
						'placeholder -> "Verf�gbare Sitzpl�tze",
		                'class -> "form-control",
		                'type -> "number",
		                'max -> "9",
		                'min -> "1",
		                '_label -> "Sitzpl�tze", 
		                '_error -> angebotForm.error("seats"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*82.16*/("""
		        <div class="actions col-md-8">
					<input type="button" id="wegPunkteHinzufuegen" class="btn btn-default" value="Wegpunkte hinfzuf�gen."></button>
					<input type="submit" class="btn btn-default" value="Mitfahrgelegenheit eintragen.">
				</div>
		        </fieldset>
		
		    """)))})),format.raw/*89.8*/("""
		<div class="col-md-8 form-group" style="height:630px" id="map-canvas"></div>

    </div>

<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjsbaoEWBxF2oxvLEenqLjERjfJICyyWg&sensor=true">
</script>
 	<script type="text/javascript" src="/assets/javascripts/omm_createOffer.js"></script>
 	<script type="text/javascript" src="/assets/javascripts/main.js"></script>
""")))})))}
    }
    
    def render(angebotForm:Form[Route],fixedPoints:HashMap[String, String]): play.api.templates.HtmlFormat.Appendable = apply(angebotForm)(fixedPoints)
    
    def f:((Form[Route]) => (HashMap[String, String]) => play.api.templates.HtmlFormat.Appendable) = (angebotForm) => (fixedPoints) => apply(angebotForm)(fixedPoints)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/angebotErstellen.scala.html
                    HASH: 47ca61135a419cebba3047c2a9482d74f18979c4
                    MATRIX: 814->1|1022->65|1050->118|1086->120|1109->135|1148->137|1280->234|1295->240|1380->316|1420->318|1549->411|1945->785|1997->801|2266->1049|2365->1112|2759->1484|2826->1515|3095->1763|3153->1785|3536->2146|3588->2162|3975->2527|4027->2543|4479->2973|4801->3264
                    LINES: 26->1|32->1|34->5|35->6|35->6|35->6|40->11|40->11|40->11|40->11|44->15|52->23|53->24|60->31|63->34|71->42|73->44|80->51|82->53|90->61|91->62|99->70|100->71|111->82|118->89
                    -- GENERATED --
                */
            