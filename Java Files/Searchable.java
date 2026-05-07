public interface Searchable {
    LibraryItem findItemByCode(String code);
    Member findMemberById(String id);
}