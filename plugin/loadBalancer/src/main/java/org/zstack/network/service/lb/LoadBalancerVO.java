package org.zstack.network.service.lb;

import org.zstack.header.vo.NoView;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by frank on 8/7/2015.
 */
@Entity
@Table
public class LoadBalancerVO {
    @Id
    @Column
    private String uuid;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private LoadBalancerState state;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="loadBalancerUuid", insertable=false, updatable=false)
    @NoView
    private Set<LoadBalancerVipRefVO> vipRefs = new HashSet<LoadBalancerVipRefVO>();

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="loadBalancerUuid", insertable=false, updatable=false)
    @NoView
    private Set<LoadBalancerListenerVO> listeners = new HashSet<LoadBalancerListenerVO>();

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="loadBalancerUuid", insertable=false, updatable=false)
    @NoView
    private Set<LoadBalancerVmNicRefVO> vmNicRefs = new HashSet<LoadBalancerVmNicRefVO>();

    @Column
    private Timestamp createDate;

    @Column
    private Timestamp lastOpDate;

    public Set<LoadBalancerListenerVO> getListeners() {
        return listeners;
    }

    public void setListeners(Set<LoadBalancerListenerVO> listeners) {
        this.listeners = listeners;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LoadBalancerState getState() {
        return state;
    }

    public void setState(LoadBalancerState state) {
        this.state = state;
    }

    public Set<LoadBalancerVipRefVO> getVipRefs() {
        return vipRefs;
    }

    public void setVipRefs(Set<LoadBalancerVipRefVO> vipRefs) {
        this.vipRefs = vipRefs;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastOpDate() {
        return lastOpDate;
    }

    public void setLastOpDate(Timestamp lastOpDate) {
        this.lastOpDate = lastOpDate;
    }

    public Set<LoadBalancerVmNicRefVO> getVmNicRefs() {
        return vmNicRefs;
    }

    public void setVmNicRefs(Set<LoadBalancerVmNicRefVO> vmNicRefs) {
        this.vmNicRefs = vmNicRefs;
    }
}
