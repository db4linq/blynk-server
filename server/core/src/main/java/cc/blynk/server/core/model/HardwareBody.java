package cc.blynk.server.core.model;

import cc.blynk.server.core.model.enums.PinType;
import cc.blynk.utils.ParseUtil;
import cc.blynk.utils.StringUtils;

import java.util.Arrays;

/**
 * The Blynk Project.
 * Created by Dmitriy Dumanskiy.
 * Created on 02.11.15.
 */
public class HardwareBody {

    public PinType type;
    public byte pin;
    public String[] value;

    public HardwareBody(String[] splitted, int msgId) {
        this.type = PinType.getPingType(splitted[0].charAt(0));
        this.pin = ParseUtil.parseByte(splitted[1], msgId);
        this.value = Arrays.copyOfRange(splitted, 2, splitted.length);
    }

    public HardwareBody(PinType type, byte pin, String[] value) {
        this.type = type;
        this.pin = pin;
        this.value = value;
    }

    public HardwareBody(String body, int msgId) {
        this(body.split(StringUtils.BODY_SEPARATOR_STRING), msgId);
    }

}
