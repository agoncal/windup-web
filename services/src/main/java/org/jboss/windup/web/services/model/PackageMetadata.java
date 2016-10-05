package org.jboss.windup.web.services.model;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Contains information about package discovery status and discovered packages
 *
 * @author <a href="mailto:dklingenberg@gmail.com">David Klingenberg</a>
 */
@Entity
public class PackageMetadata
{
    /**
     * Status of package discovery
     */
    public enum ScanStatus
    {
        QUEUED, IN_PROGRESS, COMPLETE
    }

    public static final String PACKAGE_METADATA_ID = "package_metadata_id";

    public PackageMetadata()
    {
        this.discoveredDate = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = PACKAGE_METADATA_ID, updatable = false, nullable = false)
    private Long id;

    @Column()
    private Date discoveredDate;

    @Column()
    private ScanStatus scanStatus;

    @OneToMany()
    private Set<Package> packages;

    public Long getId()
    {
        return id;
    }

    /**
     * Gets date when package discovery was run
     *
     * @return Date when package discovery was run
     */
    public Date getDiscoveredDate()
    {
        return discoveredDate;
    }

    /**
     * Sets date when package discovery was run
     *
     * @param discoveredDate  Date when package discovery was run
     */
    public void setDiscoveredDate(Date discoveredDate)
    {
        this.discoveredDate = discoveredDate;
    }

    /**
     * Gets status of the package discovery
     *
     * @return Status of package discovery
     */
    public ScanStatus getScanStatus()
    {
        return scanStatus;
    }

    /**
     * Sets status of the package discovery
     *
     * @param scanStatus  Status of package discovery
     */
    public void setScanStatus(ScanStatus scanStatus)
    {
        this.scanStatus = scanStatus;
    }

    /**
     * Gets discovered packages
     *
     * @return Discovered packages
     */
    public Collection<Package> getPackages()
    {
        return packages;
    }

    /**
     * Adds discovered package
     *
     * @param aPackage Discovered package
     */
    public void addPackage(Package aPackage)
    {
        this.packages.add(aPackage);
    }

    /**
     * Removes discovered package
     *
     * @param aPackage Discovered package
     */
    public void removePackage(Package aPackage)
    {
        this.packages.remove(aPackage);
    }
}
