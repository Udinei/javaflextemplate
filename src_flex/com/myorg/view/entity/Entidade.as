package com.myorg.view.entity
{
	 import mx.core.UIComponent;
                   
	[RemoteClass(alias="com.myorg.business.entitys.Entidade")]	
	[Bindable]
	public class Entidade
	{   
		public var id:Number;
		public var name:String;
	}
}