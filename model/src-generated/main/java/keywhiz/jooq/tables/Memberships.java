/*
 * This file is generated by jOOQ.
 */
package keywhiz.jooq.tables;


import java.util.Arrays;
import java.util.List;

import keywhiz.jooq.Indexes;
import keywhiz.jooq.Keys;
import keywhiz.jooq.KeywhizdbTest;
import keywhiz.jooq.tables.records.MembershipsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Memberships extends TableImpl<MembershipsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keywhizdb_test.memberships</code>
     */
    public static final Memberships MEMBERSHIPS = new Memberships();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MembershipsRecord> getRecordType() {
        return MembershipsRecord.class;
    }

    /**
     * The column <code>keywhizdb_test.memberships.id</code>.
     */
    public final TableField<MembershipsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>keywhizdb_test.memberships.groupid</code>.
     */
    public final TableField<MembershipsRecord, Long> GROUPID = createField(DSL.name("groupid"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.memberships.clientid</code>.
     */
    public final TableField<MembershipsRecord, Long> CLIENTID = createField(DSL.name("clientid"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.memberships.updatedat</code>.
     */
    public final TableField<MembershipsRecord, Long> UPDATEDAT = createField(DSL.name("updatedat"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.memberships.createdat</code>.
     */
    public final TableField<MembershipsRecord, Long> CREATEDAT = createField(DSL.name("createdat"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.memberships.row_hmac</code>.
     */
    public final TableField<MembershipsRecord, String> ROW_HMAC = createField(DSL.name("row_hmac"), SQLDataType.VARCHAR(64).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    private Memberships(Name alias, Table<MembershipsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Memberships(Name alias, Table<MembershipsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keywhizdb_test.memberships</code> table reference
     */
    public Memberships(String alias) {
        this(DSL.name(alias), MEMBERSHIPS);
    }

    /**
     * Create an aliased <code>keywhizdb_test.memberships</code> table reference
     */
    public Memberships(Name alias) {
        this(alias, MEMBERSHIPS);
    }

    /**
     * Create a <code>keywhizdb_test.memberships</code> table reference
     */
    public Memberships() {
        this(DSL.name("memberships"), null);
    }

    public <O extends Record> Memberships(Table<O> child, ForeignKey<O, MembershipsRecord> key) {
        super(child, key, MEMBERSHIPS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KeywhizdbTest.KEYWHIZDB_TEST;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.MEMBERSHIPS_MEMBERSHIPS_GROUPID_IDX);
    }

    @Override
    public Identity<MembershipsRecord, Long> getIdentity() {
        return (Identity<MembershipsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MembershipsRecord> getPrimaryKey() {
        return Keys.KEY_MEMBERSHIPS_PRIMARY;
    }

    @Override
    public List<UniqueKey<MembershipsRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_MEMBERSHIPS_MEMBERSHIPS_CLIENTID_GROUPID_IDX);
    }

    @Override
    public Memberships as(String alias) {
        return new Memberships(DSL.name(alias), this);
    }

    @Override
    public Memberships as(Name alias) {
        return new Memberships(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Memberships rename(String name) {
        return new Memberships(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Memberships rename(Name name) {
        return new Memberships(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, Long, Long, Long, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
