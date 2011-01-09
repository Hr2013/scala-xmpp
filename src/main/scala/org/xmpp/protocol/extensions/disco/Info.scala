package org.xmpp
{
	package protocol.extensions.disco
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.iq._
		
		import org.xmpp.protocol.Protocol._
		
		object Info extends ExtendedStanzaBuilder[Info]
		{
			val kind = Get.kindName
			val name = Query.name
			val namespace = "http://jabber.org/protocol/disco#info"
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID]):Info = 
			{
				val xml = Get.build(id, to, from, Query(namespace))
				return apply(xml)
			}
			
			def apply(xml:Node):Info = new Info(xml)
		}
		
		class Info(xml:Node) extends Get(xml)
		{
			def result(identity:Identity, feature:Feature):InfoResult = InfoResult(this.id, this.from, this.to, List(identity), List(feature))
			def result(identity:Identity, features:Seq[Feature]):InfoResult = InfoResult(this.id, this.from, this.to, List(identity), features)
			def result(identities:Seq[Identity], features:Seq[Feature]):InfoResult = InfoResult(this.id, this.from, this.to, identities, features)
		}
		
	}
}