package com.myorg.view.entity
{
	 import mx.core.UIComponent;
                   
	[RemoteClass(alias="com.myorg.business.entitys.Product")]	
	[Bindable]
	public class Product
	{   
		public var id:Number;
		public var name:String;
	}
}