/*
 * (C) Copyright Resse Christophe 2021 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Resse Christophe. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Resse C. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Resse Christophe (christophe.resse@gmail.com).
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.backend.persistence.person.service;

import com.hemajoo.commerce.cherry.backend.commons.type.StatusType;
import com.hemajoo.commerce.cherry.backend.persistence.base.entity.AbstractServerAuditEntity;
import com.hemajoo.commerce.cherry.backend.persistence.base.entity.AbstractServerStatusEntity;
import com.hemajoo.commerce.cherry.backend.persistence.base.specification.GenericSpecification;
import com.hemajoo.commerce.cherry.backend.persistence.person.entity.PostalAddressServer;
import com.hemajoo.commerce.cherry.backend.persistence.person.repository.PostalAddressRepository;
import com.hemajoo.commerce.cherry.backend.shared.base.search.criteria.SearchCriteria;
import com.hemajoo.commerce.cherry.backend.shared.base.search.criteria.SearchOperation;
import com.hemajoo.commerce.cherry.backend.shared.person.address.AddressType;
import com.hemajoo.commerce.cherry.backend.shared.person.address.postal.PostalAddressSearch;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of the postal address persistence service.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Service
public class PostalAddressService implements IPostalAddressService
{
    /**
     * Repository for the postal addresses.
     */
    @Autowired
    private PostalAddressRepository postalAddressRepository;


    @Override
    public Long count()
    {
        return postalAddressRepository.count();
    }

    @Override
    public PostalAddressServer findById(UUID id)
    {
        return postalAddressRepository.findById(id).orElse(null);
    }

    @Override
    public PostalAddressServer save(PostalAddressServer postalAddress)
    {
        return postalAddressRepository.save(postalAddress);
    }

    @Override
    public void deleteById(UUID id)
    {
        postalAddressRepository.deleteById(id);
    }

    @Override
    public List<PostalAddressServer> findAll()
    {
        return postalAddressRepository.findAll();
    }

    @Override
    public List<PostalAddressServer> findByAddressType(AddressType type)
    {
        return postalAddressRepository.findByAddressType(type);
    }

    @Override
    public List<PostalAddressServer> findByStatus(StatusType status)
    {
        return postalAddressRepository.findByStatusType(status);
    }

    @Override
    public List<PostalAddressServer> findByIsDefault(boolean isDefault)
    {
        return postalAddressRepository.findByIsDefault(isDefault);
    }

    @Override
    public List<PostalAddressServer> findByPersonId(UUID personId)
    {
        return postalAddressRepository.findByPersonId(personId);
    }

    @Override
    public List<PostalAddressServer> search(@NonNull PostalAddressSearch postalAddress)
    {
        GenericSpecification<PostalAddressServer> specification = new GenericSpecification<>();

        // Inherited fields
        if (postalAddress.getCreatedBy() != null)
        {
            specification.add(new SearchCriteria(
                    AbstractServerAuditEntity.FIELD_CREATED_BY,
                    postalAddress.getCreatedBy(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getModifiedBy() != null)
        {
            specification.add(new SearchCriteria(
                    AbstractServerAuditEntity.FIELD_MODIFIED_BY,
                    postalAddress.getModifiedBy(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getStatusType() != null)
        {
            specification.add(new SearchCriteria(
                    AbstractServerStatusEntity.FIELD_STATUS_TYPE,
                    postalAddress.getStatusType(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getId() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_ID,
                    postalAddress.getId(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getIsDefault() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_IS_DEFAULT,
                    postalAddress.getIsDefault(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getAddressType() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_ADDRESS_TYPE,
                    postalAddress.getAddressType(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getPersonId() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_PERSON_ID,
                    postalAddress.getPersonId(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getCategoryType() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_CATEGORY_TYPE,
                    postalAddress.getCategoryType(),
                    SearchOperation.EQUAL));
        }

        if (postalAddress.getArea() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_AREA,
                    postalAddress.getArea(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getCountryCode() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_COUNTRY_CODE,
                    postalAddress.getCountryCode(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getLocality() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_LOCALITY,
                    postalAddress.getLocality(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getStreetName() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_STREET_NAME,
                    postalAddress.getStreetName(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getStreetNumber() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_STREET_NUMBER,
                    postalAddress.getStreetNumber(),
                    SearchOperation.MATCH));
        }

        if (postalAddress.getZipCode() != null)
        {
            specification.add(new SearchCriteria(
                    PostalAddressServer.FIELD_ZIP_CODE,
                    postalAddress.getZipCode(),
                    SearchOperation.MATCH));
        }

        return postalAddressRepository.findAll(specification);
    }
}
