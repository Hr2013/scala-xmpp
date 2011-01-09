package org.xmpp
{
	package protocol.iq
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.Protocol._
		
		object Get
		{
			def apply(id:Option[String], to:Option[JID], from:Option[JID], extensions:Option[Seq[Extension]]=None):Get = apply(build(id, to, from, extensions)) 
			
			def apply(xml:Node):Get = new Get(xml)
			
			def build(id:Option[String], to:Option[JID], from:Option[JID], extensions:Option[Seq[Extension]]=None):Node = IQ.build(IQTypeEnumeration.Get, id, to, from, extensions)
		}
		
		class Get(xml:Node) extends IQ(xml, IQTypeEnumeration.Get)
		{
			def result(extensions:Option[Seq[Extension]]):Result = Result(this.id, this.from, this.to, extensions)
		}
		
	}
}
