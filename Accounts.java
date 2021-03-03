// ORM class for table 'Accounts'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Feb 25 15:23:04 EST 2021
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Accounts extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer Account_Id;
  public Integer get_Account_Id() {
    return Account_Id;
  }
  public void set_Account_Id(Integer Account_Id) {
    this.Account_Id = Account_Id;
  }
  public Accounts with_Account_Id(Integer Account_Id) {
    this.Account_Id = Account_Id;
    return this;
  }
  private String Account_name;
  public String get_Account_name() {
    return Account_name;
  }
  public void set_Account_name(String Account_name) {
    this.Account_name = Account_name;
  }
  public Accounts with_Account_name(String Account_name) {
    this.Account_name = Account_name;
    return this;
  }
  private java.sql.Date date_opened;
  public java.sql.Date get_date_opened() {
    return date_opened;
  }
  public void set_date_opened(java.sql.Date date_opened) {
    this.date_opened = date_opened;
  }
  public Accounts with_date_opened(java.sql.Date date_opened) {
    this.date_opened = date_opened;
    return this;
  }
  private Integer customer_id;
  public Integer get_customer_id() {
    return customer_id;
  }
  public void set_customer_id(Integer customer_id) {
    this.customer_id = customer_id;
  }
  public Accounts with_customer_id(Integer customer_id) {
    this.customer_id = customer_id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Accounts)) {
      return false;
    }
    Accounts that = (Accounts) o;
    boolean equal = true;
    equal = equal && (this.Account_Id == null ? that.Account_Id == null : this.Account_Id.equals(that.Account_Id));
    equal = equal && (this.Account_name == null ? that.Account_name == null : this.Account_name.equals(that.Account_name));
    equal = equal && (this.date_opened == null ? that.date_opened == null : this.date_opened.equals(that.date_opened));
    equal = equal && (this.customer_id == null ? that.customer_id == null : this.customer_id.equals(that.customer_id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.Account_Id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.Account_name = JdbcWritableBridge.readString(2, __dbResults);
    this.date_opened = JdbcWritableBridge.readDate(3, __dbResults);
    this.customer_id = JdbcWritableBridge.readInteger(4, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(Account_Id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(Account_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDate(date_opened, 3 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeInteger(customer_id, 4 + __off, 4, __dbStmt);
    return 4;
  }
  public void readFields(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.Account_Id = null;
    } else {
    this.Account_Id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.Account_name = null;
    } else {
    this.Account_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.date_opened = null;
    } else {
    this.date_opened = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.customer_id = null;
    } else {
    this.customer_id = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.Account_Id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.Account_Id);
    }
    if (null == this.Account_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Account_name);
    }
    if (null == this.date_opened) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.date_opened.getTime());
    }
    if (null == this.customer_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.customer_id);
    }
  }
  private final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(Account_Id==null?"null":"" + Account_Id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Account_name==null?"null":Account_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(date_opened==null?"null":"" + date_opened, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(customer_id==null?"null":"" + customer_id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  private final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str;
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Account_Id = null; } else {
      this.Account_Id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Account_name = null; } else {
      this.Account_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.date_opened = null; } else {
      this.date_opened = java.sql.Date.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.customer_id = null; } else {
      this.customer_id = Integer.valueOf(__cur_str);
    }

  }

  public Object clone() throws CloneNotSupportedException {
    Accounts o = (Accounts) super.clone();
    o.date_opened = (o.date_opened != null) ? (java.sql.Date) o.date_opened.clone() : null;
    return o;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("Account_Id", this.Account_Id);
    __sqoop$field_map.put("Account_name", this.Account_name);
    __sqoop$field_map.put("date_opened", this.date_opened);
    __sqoop$field_map.put("customer_id", this.customer_id);
    return __sqoop$field_map;
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("Account_Id".equals(__fieldName)) {
      this.Account_Id = (Integer) __fieldVal;
    }
    else    if ("Account_name".equals(__fieldName)) {
      this.Account_name = (String) __fieldVal;
    }
    else    if ("date_opened".equals(__fieldName)) {
      this.date_opened = (java.sql.Date) __fieldVal;
    }
    else    if ("customer_id".equals(__fieldName)) {
      this.customer_id = (Integer) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
}
