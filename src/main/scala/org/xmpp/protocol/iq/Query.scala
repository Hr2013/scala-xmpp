package org.xmpp
{
	package protocol.iq
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.Protocol._
		
		object Query
		{
			def NAME = "query"
				
			def apply(namespace:String):Query = apply(Extension.build(NAME, namespace))
			
			def apply(namespace:String, children:Option[Seq[Node]]):Query = apply(Extension.build(NAME, namespace, None, children))
			
			def apply(xml:Node):Query = new Query(xml)
		}
		
		class Query(xml:Node) extends Extension(xml) 
		{
		}
	}
}