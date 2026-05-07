public interface Borrowable {
    boolean borrowTo(Member member);
    boolean returnItem();
    boolean isAvailable();
}