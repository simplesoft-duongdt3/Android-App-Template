package tinyapps.apptemplate.base.listener;

public interface OnInteractionListener<T> {
    void onSendInteractionEvent(T item, int pos, int action);
}
