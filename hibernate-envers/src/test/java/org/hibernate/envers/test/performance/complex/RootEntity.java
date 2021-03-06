/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */

package org.hibernate.envers.test.performance.complex;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
@Audited
public class RootEntity {
    @Id
    private Long id;

    private String data1;

    private String data2;

    private Integer number1;

    private Integer number2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;

    @ManyToOne(cascade = CascadeType.ALL)
    private ChildEntity1 child1;

    @ManyToOne(cascade = CascadeType.ALL)
    private ChildEntity1 child2;

    @ManyToOne(cascade = CascadeType.ALL)
    private ChildEntity1 child3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public ChildEntity1 getChild1() {
        return child1;
    }

    public void setChild1(ChildEntity1 child1) {
        this.child1 = child1;
    }

    public ChildEntity1 getChild2() {
        return child2;
    }

    public void setChild2(ChildEntity1 child2) {
        this.child2 = child2;
    }

    public ChildEntity1 getChild3() {
        return child3;
    }

    public void setChild3(ChildEntity1 child3) {
        this.child3 = child3;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RootEntity)) return false;

        RootEntity that = (RootEntity) o;

        if (data1 != null ? !data1.equals(that.data1) : that.data1 != null) return false;
        if (data2 != null ? !data2.equals(that.data2) : that.data2 != null) return false;
        if (date1 != null ? !date1.equals(that.date1) : that.date1 != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (number1 != null ? !number1.equals(that.number1) : that.number1 != null) return false;
        if (number2 != null ? !number2.equals(that.number2) : that.number2 != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (data1 != null ? data1.hashCode() : 0);
        result = 31 * result + (data2 != null ? data2.hashCode() : 0);
        result = 31 * result + (number1 != null ? number1.hashCode() : 0);
        result = 31 * result + (number2 != null ? number2.hashCode() : 0);
        result = 31 * result + (date1 != null ? date1.hashCode() : 0);
        return result;
    }
}
