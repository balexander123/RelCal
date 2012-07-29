package com.gap.mongo.converters;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Note: This implements {@link SimpleValueConverter} even though
 * {@link #decode(Class, Object, MappedField)} does not return a simple value.
 * This must be done so that Morphia's mapper logic uses this converter when
 * converting a {@link Date} to a {@link DateTime}.
 */
public class DateTimeConverter extends TypeConverter
    implements SimpleValueConverter {

  public static final String MILLIS_PROPERTY_NAME = "t";
  public static final String TIME_ZONE_PROPERTY_NAME = "z";

  public DateTimeConverter() {
    super(DateTime.class);
  }

  /**
   * @param value is expected to be a {@link DateTime}
   */
  @Override
  public final Object encode(Object value, MappedField optionalExtraInfo)
      throws MappingException {
    if (value == null) {
      return null;
    }

    if (!(value instanceof DateTime)) {
      throw new RuntimeException(
          "Did not expect " + value.getClass().getName());
    }

    DateTime dateTime = (DateTime)value;
    DBObject obj = new BasicDBObject();
    obj.put(MILLIS_PROPERTY_NAME, dateTime.getMillis());
    obj.put(TIME_ZONE_PROPERTY_NAME, dateTime.getZone().getID());
    return obj;
  }

  /**
   * @param fromDBObject is expected to be a {@link Map} with the fields
   *     serialized in {@link PartialDateTime}
   */
  @Override
  public DateTime decode(Class targetClass, Object fromDBObject,
      MappedField optionalExtraInfo) {
    if (fromDBObject == null) {
      return null;
    }

    if (fromDBObject instanceof Map) {
      Map<String, String> map = (Map)fromDBObject;
      long millis = Long.parseLong(map.get(
          MILLIS_PROPERTY_NAME));
      return new DateTime(millis, DateTimeZone.forID(map.get(
          TIME_ZONE_PROPERTY_NAME)));
    }

    throw new RuntimeException(
        "Did not expect "  + fromDBObject.getClass().getName());
  }
}
