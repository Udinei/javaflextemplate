// ActionScript file
package br.com.webinovacoes.componentes.formularios
{
	import mx.collections.ArrayCollection;
	import mx.controls.ComboBox;
	import mx.events.FlexEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class Combo extends ComboBox{
		
		
		public function Combo(){
				super();
				ServiceConsulta();
    	}
    	
	
		/**
		* @Selecina ID
		* Seleciona ID
		*/
		public function SelecionaId(value:Number):void{

			//Also ensure it is not there in the dataProvider
			var att:Object = new Object();
				for ( var i:Number=0;i<=dataProvider.list.length-1;i++){

					att=dataProvider.getItemAt(i);
					if (att.id == value){
						this.selectedIndex=i;
						break;
					}
	  			}
   		}
   
   
	/* Nome do Servico q vai preencher o combo */
	[Bindable]
	public var service:String;

	/**
	* Função para Buscar dados no servidor
	*/
	[Bindable]
	private var lista:ArrayCollection;
	
	private function ServiceConsulta():void{

		if(service != null){
		
			// Carrega Combo ECF
			var cnn:RemoteObject = new RemoteObject();
			cnn.destination = service+”Service”;
			cnn.consulta();

			/* Adiciona evento */
			cnn.addEventListener(ResultEvent.RESULT, function(event:ResultEvent):void{
				lista = event.result as ArrayCollection;
	         	dataProvider =lista;});
		}
	}
	
  }//fim classe combo
}

