
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
object angebotAendern extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Route,Form[Route],HashMap[String, String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(Route:  Route)(angebotForm: Form[Route])(fixedPoints: HashMap[String, String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.81*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("HöriMit")/*6.17*/ {_display_(Seq[Any](format.raw/*6.19*/("""
<div class="starter-template">
    <h1>Mitfahrgelegenheit ändern</h1>
</div>

     """),_display_(Seq[Any](/*11.7*/helper/*11.13*/.form(action = routes.Angebote.changeOffer(Route._id), 'Id -> "changeForm", 'class -> "form-group col-md-8")/*11.121*/ {_display_(Seq[Any](format.raw/*11.123*/("""
 		       
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
	                	'_default -> "Bitte auswählen.",
		                '_class -> "col-md-6"
					))),format.raw/*31.7*/("""
					"""),_display_(Seq[Any](/*32.7*/for(key <- 0 until Route.wegpunkte.size()) yield /*32.49*/{_display_(Seq[Any](format.raw/*32.50*/("""
				    	<div class="waypoints">
				    	<div class="clearfix col-md-6"><label for=wegpunkt"""),_display_(Seq[Any](/*34.61*/{key})),format.raw/*34.66*/("""">Wegpunkt """),_display_(Seq[Any](/*34.78*/{key+1})),format.raw/*34.85*/("""</label>
						   	<div class="input"><input class="form-control" name="wegpunkt"""),_display_(Seq[Any](/*35.73*/{key})),format.raw/*35.78*/("""" id="wegpunkt"""),_display_(Seq[Any](/*35.93*/{key})),format.raw/*35.98*/("""" type="text" placeholder="�ber Adresse" value=""""),_display_(Seq[Any](/*35.147*/{Route.wegpunkteForm.get(key)})),format.raw/*35.177*/("""">
						   	<span class="help-inline"></span><span class="help-block"></span></div>
						   	</div>
							"""),_display_(Seq[Any](/*38.9*/select(
								angebotForm("wegpunkt"+(key)+"Select"),
								options = options(fixedPoints),
								'class -> "form-control",				
								'_label -> {"Wegpunkt "+(key+1)},
			                	'_default -> "Bitte auswählen.",
				                '_class -> "col-md-6"
							))),format.raw/*45.9*/("""
					    	</div>
					""")))})),format.raw/*47.7*/("""
					<div id="wegpunkte"></div>
		            
		            """),_display_(Seq[Any](/*50.16*/inputText(
		                angebotForm("zielAdresseForm"), 
		                'placeholder -> "Bitte eine Startadresse eingeben.",
		                'class -> "form-control",
		                '_label -> "Zieladresse", 
		                '_error -> angebotForm.error("zielAdresse"),
		                '_help -> "",
		                '_class -> "col-md-6"
		            ))),format.raw/*58.16*/("""
		            
		           	"""),_display_(Seq[Any](/*60.16*/select(
						angebotForm("zielAdresseFormSelect"),
						options = options(fixedPoints),
						'class -> "form-control",				
						'_label -> "Nach",
	                	'_default -> "Bitte auswählen.",
		                '_class -> "col-md-6"
					))),format.raw/*67.7*/("""
					
		            """),_display_(Seq[Any](/*69.16*/inputText(
		                angebotForm("timeForm"), 
		                'placeholder -> "Bitte eine Uhrzeit eingeben im Format hh:mm",
		                'class -> "form-control",
		                '_label -> "Zeit", 
		                '_error -> angebotForm.error("zeit"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*77.16*/("""
		            """),_display_(Seq[Any](/*78.16*/inputDate(
		                angebotForm("dateForm"), 
		                'placeholder -> "Bitte ein Datum eingeben im Format tt.mm.yyyy",
		                'class -> "form-control",
		                '_label -> "Datum", 
		                '_error -> angebotForm.error("datum"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*86.16*/("""
		            """),_display_(Seq[Any](/*87.16*/inputText(
		                angebotForm("seats"), 
						'placeholder -> "Verfügbare Sitzplätze",
		                'class -> "form-control",
		                'type -> "number",
		                'max -> "9",
		                'min -> "1",
		                '_label -> "Sitzplätze", 
		                '_error -> angebotForm.error("seats"),
		                '_help -> "",
		                '_class -> "col-md-4"
		            ))),format.raw/*98.16*/("""
		        <div class="actions col-md-8">
					<input type="button" id="wegPunkteHinzufuegen" class="btn btn-default" value="Wegpunkte hinfzuf�gen."></button>
					<input type="submit" class="btn btn-default" value="Mitfahrgelegenheit speichern.">
				</div>
		        </fieldset>
    """)))})),format.raw/*104.6*/("""
   	<div id="map-canvas"""),_display_(Seq[Any](/*105.25*/{Route._id})),format.raw/*105.36*/("""" class="col-md-12 map-canvas" style="height:400px;"></div>
    
 	<script type="text/javascript" src="/assets/javascripts/omm_createOffer.js"></script>
    <script type="text/javascript">
    $(document).ready(function()"""),format.raw/*109.33*/("""{"""),format.raw/*109.34*/("""
    	//$("#startAdresseFormSelect").val('Radolfzell Bahnhof');
    	$("input").each(function(key, value)"""),format.raw/*111.42*/("""{"""),format.raw/*111.43*/("""
    		var text = $(value).val();
    		var id = $(value).attr('id');
    		$("#"+id+"Select option:contains("+text+")").attr('selected', true);
    	"""),format.raw/*115.6*/("""}"""),format.raw/*115.7*/(""");
    	//$("#startAdresseFormSelect option:contains('Radolfzell Bahnhof')").attr('selected', true);
    """),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""");
/*     //set counter for additional waypoints, delimiter will be "//"
    var counter = 0;
    $("#wegPunkteHinzufuegen").click(function()"""),format.raw/*120.48*/("""{"""),format.raw/*120.49*/("""
    	counter += 1;
    	var html = $("#wegpunkte").html();
    	html += '<div class="clearfix form-group"><label for="wegpunkte'+counter+'">�ber</label>';
    	html += '<div class="input"><input class="form-control" name="wegpunkte'+counter+'" id="wegpunkte'+counter+'" type="text" placeholder="�ber Adresse"></div>';
    	html += '<span class="help-block">Required</span></div>';
	   	$("#wegpunkte").html(html);

    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/(""");
	$("#abschicken").click(function(event)"""),format.raw/*129.40*/("""{"""),format.raw/*129.41*/("""
		event.preventDefault();
		var id = $(this).parent().find(".omm_value-offer").val();
		console.log(id);
		jsRoutes.controllers.Angebote.angebotAendern(id).ajax("""),format.raw/*133.57*/("""{"""),format.raw/*133.58*/("""
			data:$("#changeForm").serialize(),
	        type:"PUT"
        """),format.raw/*136.9*/("""}"""),format.raw/*136.10*/(""");
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/("""); */
    </script>
 """)))})))}
    }
    
    def render(Route:Route,angebotForm:Form[Route],fixedPoints:HashMap[String, String]): play.api.templates.HtmlFormat.Appendable = apply(Route)(angebotForm)(fixedPoints)
    
    def f:((Route) => (Form[Route]) => (HashMap[String, String]) => play.api.templates.HtmlFormat.Appendable) = (Route) => (angebotForm) => (fixedPoints) => apply(Route)(angebotForm)(fixedPoints)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 16:30:07 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec/webTec/app/views/angebotAendern.scala.html
                    HASH: 5aad9786af106baa9eb3cd4126114f853897f2d9
                    MATRIX: 818->1|1043->80|1073->137|1110->140|1133->155|1172->157|1297->247|1312->253|1430->361|1471->363|1605->461|2009->843|2062->860|2338->1115|2381->1123|2439->1165|2478->1166|2610->1262|2637->1267|2685->1279|2714->1286|2832->1368|2859->1373|2910->1388|2937->1393|3023->1442|3076->1472|3224->1585|3531->1871|3588->1897|3690->1963|4092->2343|4161->2376|4437->2631|4497->2655|4888->3024|4941->3041|5336->3414|5389->3431|5852->3872|6176->4164|6239->4190|6273->4201|6527->4426|6557->4427|6693->4534|6723->4535|6905->4689|6934->4690|7069->4797|7098->4798|7271->4942|7301->4943|7757->5371|7786->5372|7858->5415|7888->5416|8083->5582|8113->5583|8211->5653|8241->5654|8274->5659|8303->5660
                    LINES: 26->1|32->1|34->5|35->6|35->6|35->6|40->11|40->11|40->11|40->11|44->15|52->23|53->24|60->31|61->32|61->32|61->32|63->34|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|67->38|74->45|76->47|79->50|87->58|89->60|96->67|98->69|106->77|107->78|115->86|116->87|127->98|133->104|134->105|134->105|138->109|138->109|140->111|140->111|144->115|144->115|146->117|146->117|149->120|149->120|157->128|157->128|158->129|158->129|162->133|162->133|165->136|165->136|166->137|166->137
                    -- GENERATED --
                */
            