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
package com.hemajoo.commerce.cherry.backend.commons.exception;

import com.hemajoo.commerce.cherry.backend.commons.type.EntityType;
import org.springframework.http.HttpStatus;

/**
 * Checked exception thrown to indicate an error occurred with the <b>content store</b>.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class ContentStoreException extends AbstractEntityCheckedException
{
    /**
     * Default serialization identifier.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param exception Parent exception.
     */
    public ContentStoreException(final Exception exception)
    {
        super(EntityType.DOCUMENT, exception, HttpStatus.BAD_REQUEST);
    }

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param exception Parent exception.
     * @param status {@link HttpStatus}.
     */
    public ContentStoreException(final Exception exception, final HttpStatus status)
    {
        super(EntityType.DOCUMENT, exception, status);
    }

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param message Message describing the error being the cause of the raised exception.
     */
    public ContentStoreException(final String message)
    {
        super(EntityType.DOCUMENT, message, HttpStatus.BAD_REQUEST);
    }

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param message Message describing the error being the cause of the raised exception.
     * @param status {@link HttpStatus}.
     */
    public ContentStoreException(final String message, final HttpStatus status)
    {
        super(EntityType.DOCUMENT, message, status);
    }

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param message Message describing the error being the cause of the raised exception.
     * @param exception Parent exception.
     */
    public ContentStoreException(final String message, final Exception exception)
    {
        super(EntityType.DOCUMENT, message, exception, HttpStatus.BAD_REQUEST);
    }

    /**
     * Thrown to indicate that an error occurred with the content store.
     * @param message Message describing the error being the cause of the raised exception.
     * @param exception Parent exception.
     * @param status {@link HttpStatus}.
     */
    public ContentStoreException(final String message, final Exception exception, final HttpStatus status)
    {
        super(EntityType.DOCUMENT, message, exception, status);
    }
}
