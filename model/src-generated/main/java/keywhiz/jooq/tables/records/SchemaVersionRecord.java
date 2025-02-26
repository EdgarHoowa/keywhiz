/*
 * This file is generated by jOOQ.
 */
package keywhiz.jooq.tables.records;


import keywhiz.jooq.tables.SchemaVersion;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SchemaVersionRecord extends UpdatableRecordImpl<SchemaVersionRecord> implements Record10<Long, String, String, String, String, Long, String, Long, Long, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keywhizdb_test.schema_version.installed_rank</code>.
     */
    public void setInstalledRank(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.installed_rank</code>.
     */
    public Long getInstalledRank() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.version</code>.
     */
    public void setVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.version</code>.
     */
    public String getVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.script</code>.
     */
    public void setScript(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.script</code>.
     */
    public String getScript() {
        return (String) get(4);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.checksum</code>.
     */
    public void setChecksum(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.checksum</code>.
     */
    public Long getChecksum() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.installed_by</code>.
     */
    public void setInstalledBy(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.installed_by</code>.
     */
    public String getInstalledBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.installed_on</code>.
     */
    public void setInstalledOn(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.installed_on</code>.
     */
    public Long getInstalledOn() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.execution_time</code>.
     */
    public void setExecutionTime(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.execution_time</code>.
     */
    public Long getExecutionTime() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>keywhizdb_test.schema_version.success</code>.
     */
    public void setSuccess(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>keywhizdb_test.schema_version.success</code>.
     */
    public Boolean getSuccess() {
        return (Boolean) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, String, String, Long, String, Long, Long, Boolean> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, String, String, String, String, Long, String, Long, Long, Boolean> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK;
    }

    @Override
    public Field<String> field2() {
        return SchemaVersion.SCHEMA_VERSION.VERSION;
    }

    @Override
    public Field<String> field3() {
        return SchemaVersion.SCHEMA_VERSION.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return SchemaVersion.SCHEMA_VERSION.TYPE;
    }

    @Override
    public Field<String> field5() {
        return SchemaVersion.SCHEMA_VERSION.SCRIPT;
    }

    @Override
    public Field<Long> field6() {
        return SchemaVersion.SCHEMA_VERSION.CHECKSUM;
    }

    @Override
    public Field<String> field7() {
        return SchemaVersion.SCHEMA_VERSION.INSTALLED_BY;
    }

    @Override
    public Field<Long> field8() {
        return SchemaVersion.SCHEMA_VERSION.INSTALLED_ON;
    }

    @Override
    public Field<Long> field9() {
        return SchemaVersion.SCHEMA_VERSION.EXECUTION_TIME;
    }

    @Override
    public Field<Boolean> field10() {
        return SchemaVersion.SCHEMA_VERSION.SUCCESS;
    }

    @Override
    public Long component1() {
        return getInstalledRank();
    }

    @Override
    public String component2() {
        return getVersion();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public String component4() {
        return getType();
    }

    @Override
    public String component5() {
        return getScript();
    }

    @Override
    public Long component6() {
        return getChecksum();
    }

    @Override
    public String component7() {
        return getInstalledBy();
    }

    @Override
    public Long component8() {
        return getInstalledOn();
    }

    @Override
    public Long component9() {
        return getExecutionTime();
    }

    @Override
    public Boolean component10() {
        return getSuccess();
    }

    @Override
    public Long value1() {
        return getInstalledRank();
    }

    @Override
    public String value2() {
        return getVersion();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public String value4() {
        return getType();
    }

    @Override
    public String value5() {
        return getScript();
    }

    @Override
    public Long value6() {
        return getChecksum();
    }

    @Override
    public String value7() {
        return getInstalledBy();
    }

    @Override
    public Long value8() {
        return getInstalledOn();
    }

    @Override
    public Long value9() {
        return getExecutionTime();
    }

    @Override
    public Boolean value10() {
        return getSuccess();
    }

    @Override
    public SchemaVersionRecord value1(Long value) {
        setInstalledRank(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value2(String value) {
        setVersion(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value4(String value) {
        setType(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value5(String value) {
        setScript(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value6(Long value) {
        setChecksum(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value7(String value) {
        setInstalledBy(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value8(Long value) {
        setInstalledOn(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value9(Long value) {
        setExecutionTime(value);
        return this;
    }

    @Override
    public SchemaVersionRecord value10(Boolean value) {
        setSuccess(value);
        return this;
    }

    @Override
    public SchemaVersionRecord values(Long value1, String value2, String value3, String value4, String value5, Long value6, String value7, Long value8, Long value9, Boolean value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SchemaVersionRecord
     */
    public SchemaVersionRecord() {
        super(SchemaVersion.SCHEMA_VERSION);
    }

    /**
     * Create a detached, initialised SchemaVersionRecord
     */
    public SchemaVersionRecord(Long installedRank, String version, String description, String type, String script, Long checksum, String installedBy, Long installedOn, Long executionTime, Boolean success) {
        super(SchemaVersion.SCHEMA_VERSION);

        setInstalledRank(installedRank);
        setVersion(version);
        setDescription(description);
        setType(type);
        setScript(script);
        setChecksum(checksum);
        setInstalledBy(installedBy);
        setInstalledOn(installedOn);
        setExecutionTime(executionTime);
        setSuccess(success);
    }
}
