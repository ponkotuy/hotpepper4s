package hotpepper4s;

/**
 * @author ponkotuy
 */
public enum Type {
    NORMAL(""), LITE("lite"), CREDIT_CARD("credit_card"), SPECIAL("special");

    public final String str;

    private Type(String str) {
        this.str = str;
    }
}
