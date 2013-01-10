package com.nuvola.myproject.client.web.application.widget.message;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;

public class Message {
    public static class Builder {
        private final Widget message;
        private AlertType messageStyle = AlertType.ERROR;
        private CloseDelay closeDelay = CloseDelay.DEFAULT;
        private Boolean defaultCloseButton = true;

        public Builder(String message) {
            this.message = new InlineHTML(message);
        }

        public Builder(SafeHtml message) {
            this.message = new InlineHTML(message);
        }

        public Builder(Widget message) {
            this.message = message;
            defaultCloseButton = false;
        }

        public Builder style(AlertType messageStyle) {
            this.messageStyle = messageStyle;
            return this;
        }

        public Builder closeDelay(CloseDelay closeDelay) {
            this.closeDelay = closeDelay;
            return this;
        }

        public Message build() {
            return new Message(message, messageStyle, closeDelay, defaultCloseButton);
        }
    }

    private final Widget message;
    private final AlertType messageStyle;
    private final CloseDelay closeDelay;
    private final Boolean useDefaultCloseButton;

    private Message(final Widget message, final AlertType messageStyle, final CloseDelay closeDelay,
                    final Boolean useDefaultCloseButton) {
        this.message = message;
        this.messageStyle = messageStyle;
        this.closeDelay = closeDelay;
        this.useDefaultCloseButton = useDefaultCloseButton;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message)) {
            return false;
        }
        Message rhs = (Message) o;
        return (message.equals(rhs.message) && messageStyle.equals(rhs.messageStyle));
    }

    public AlertType getMessageStyle() {
        return messageStyle;
    }

    public Widget getMessage() {
        return message;
    }

    public CloseDelay getCloseDelay() {
        return closeDelay;
    }

    public Boolean useDefaultCloseButton() {
        return useDefaultCloseButton;
    }
}
