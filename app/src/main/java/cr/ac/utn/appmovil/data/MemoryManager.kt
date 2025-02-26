package cr.ac.utn.appmovil.data
import cr.ac.utn.appmovil.identities.Contact
import cr.ac.utn.appmovil.interfaces.IDBManager

object MemoryManager: IDBManager {
    private var contactList = mutableListOf<Contact>()

    override fun add(contact: Contact) {
        contactList.add(contact)
    }

    override fun update(contact: Contact) {
        remove(contact.Id)
        add(contact)
    }

    override fun remove(id: String) {
        contactList.removeIf { it.Id.trim().equals(id.trim()) }
    }

    fun remove(contact: Contact) {
        contactList.remove(contact)
    }

    override fun getAll(): List<Contact> = contactList.toList()

    override fun getById(id: String): Contact? {
        var result = contactList.filter { it.Id.trim().equals(id.trim()) }
        return if (result.any()) result[0] else null
    }
}
