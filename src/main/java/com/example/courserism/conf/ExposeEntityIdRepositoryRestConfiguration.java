package com.example.courserism.conf;

import java.net.URI;
import java.util.List;

import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.EntityLookupRegistrar;
import org.springframework.data.rest.core.config.EnumTranslationConfiguration;
import org.springframework.data.rest.core.config.MetadataConfiguration;
import org.springframework.data.rest.core.config.ProjectionDefinitionConfiguration;
import org.springframework.data.rest.core.config.RepositoryCorsRegistry;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.config.ResourceMapping;
import org.springframework.data.rest.core.config.ResourceMappingConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.core.support.EntityLookup;
import org.springframework.hateoas.RelProvider;
import org.springframework.http.MediaType;

public class ExposeEntityIdRepositoryRestConfiguration extends RepositoryRestConfiguration
{
    private RepositoryRestConfiguration delegate;

    public ExposeEntityIdRepositoryRestConfiguration( RepositoryRestConfiguration delegate )
    {
        super( delegate.getProjectionConfiguration(), delegate.getMetadataConfiguration(),
                delegate.getEnumTranslationConfiguration() );
        this.delegate = delegate;
    }

    public int hashCode()
    {
        return delegate.hashCode();
    }

    public boolean equals( Object obj )
    {
        return delegate.equals( obj );
    }

    public URI getBaseUri()
    {
        return delegate.getBaseUri();
    }

    public URI getBasePath()
    {
        return delegate.getBasePath();
    }

    public int getDefaultPageSize()
    {
        return delegate.getDefaultPageSize();
    }

    public int getMaxPageSize()
    {
        return delegate.getMaxPageSize();
    }

    public String getPageParamName()
    {
        return delegate.getPageParamName();
    }

    public String getLimitParamName()
    {
        return delegate.getLimitParamName();
    }

    public String getSortParamName()
    {
        return delegate.getSortParamName();
    }

    public MediaType getDefaultMediaType()
    {
        return delegate.getDefaultMediaType();
    }

    public ResourceMapping getResourceMappingForDomainType( Class<?> domainType )
    {
        return delegate.getResourceMappingForDomainType( domainType );
    }

    public boolean hasResourceMappingForDomainType( Class<?> domainType )
    {
        return delegate.hasResourceMappingForDomainType( domainType );
    }

    public ResourceMappingConfiguration getDomainTypesResourceMappingConfiguration()
    {
        return delegate.getDomainTypesResourceMappingConfiguration();
    }

    public ResourceMapping getResourceMappingForRepository( Class<?> repositoryInterface )
    {
        return delegate.getResourceMappingForRepository( repositoryInterface );
    }

    public boolean hasResourceMappingForRepository( Class<?> repositoryInterface )
    {
        return delegate.hasResourceMappingForRepository( repositoryInterface );
    }

    public ResourceMapping findRepositoryMappingForPath( String path )
    {
        return delegate.findRepositoryMappingForPath( path );
    }

    public boolean isIdExposedFor( Class<?> domainType )
    {
        return true;
    }

    public RepositoryRestConfiguration exposeIdsFor( Class<?>... domainTypes )
    {
        return delegate.exposeIdsFor( domainTypes );
    }

    public ProjectionDefinitionConfiguration getProjectionConfiguration()
    {
        return delegate.getProjectionConfiguration();
    }

    public MetadataConfiguration getMetadataConfiguration()
    {
        return delegate.getMetadataConfiguration();
    }

    public boolean isEnableEnumTranslation()
    {
        return delegate.isEnableEnumTranslation();
    }

    public EnumTranslationConfiguration getEnumTranslationConfiguration()
    {
        return delegate.getEnumTranslationConfiguration();
    }

    public RepositoryDetectionStrategy getRepositoryDetectionStrategy()
    {
        return delegate.getRepositoryDetectionStrategy();
    }

    public RepositoryCorsRegistry getCorsRegistry()
    {
        return delegate.getCorsRegistry();
    }

    public List<EntityLookup<?>> getEntityLookups( Repositories repositories )
    {
        return delegate.getEntityLookups( repositories );
    }

    public RelProvider getRelProvider()
    {
        return delegate.getRelProvider();
    }

    public RepositoryRestConfiguration setBasePath( String basePath )
    {
        return delegate.setBasePath( basePath );
    }

    public RepositoryRestConfiguration setDefaultPageSize( int defaultPageSize )
    {
        return delegate.setDefaultPageSize( defaultPageSize );
    }

    public RepositoryRestConfiguration setMaxPageSize( int maxPageSize )
    {
        return delegate.setMaxPageSize( maxPageSize );
    }

    public RepositoryRestConfiguration setPageParamName( String pageParamName )
    {
        return delegate.setPageParamName( pageParamName );
    }

    public RepositoryRestConfiguration setLimitParamName( String limitParamName )
    {
        return delegate.setLimitParamName( limitParamName );
    }

    public RepositoryRestConfiguration setSortParamName( String sortParamName )
    {
        return delegate.setSortParamName( sortParamName );
    }

    public RepositoryRestConfiguration setDefaultMediaType( MediaType defaultMediaType )
    {
        return delegate.setDefaultMediaType( defaultMediaType );
    }

    public String toString()
    {
        return delegate.toString();
    }

    public boolean useHalAsDefaultJsonMediaType()
    {
        return delegate.useHalAsDefaultJsonMediaType();
    }

    public RepositoryRestConfiguration useHalAsDefaultJsonMediaType( boolean useHalAsDefaultJsonMediaType )
    {
        return delegate.useHalAsDefaultJsonMediaType( useHalAsDefaultJsonMediaType );
    }

    public RepositoryRestConfiguration setReturnBodyForPutAndPost( Boolean returnBody )
    {
        return delegate.setReturnBodyForPutAndPost( returnBody );
    }

    public Boolean isReturnBodyOnCreate()
    {
        return delegate.isReturnBodyOnCreate();
    }

    public boolean returnBodyOnCreate( String acceptHeader )
    {
        return delegate.returnBodyOnCreate( acceptHeader );
    }

    public RepositoryRestConfiguration setReturnBodyOnCreate( Boolean returnBody )
    {
        return delegate.setReturnBodyOnCreate( returnBody );
    }

    public Boolean isReturnBodyOnUpdate()
    {
        return delegate.isReturnBodyOnUpdate();
    }

    public boolean returnBodyOnUpdate( String acceptHeader )
    {
        return delegate.returnBodyOnUpdate( acceptHeader );
    }

    public RepositoryRestConfiguration setReturnBodyOnUpdate( Boolean returnBodyOnUpdate )
    {
        return delegate.setReturnBodyOnUpdate( returnBodyOnUpdate );
    }

    public ResourceMapping setResourceMappingForDomainType( Class<?> domainType )
    {
        return delegate.setResourceMappingForDomainType( domainType );
    }

    public ResourceMapping setResourceMappingForRepository( Class<?> repositoryInterface )
    {
        return delegate.setResourceMappingForRepository( repositoryInterface );
    }

    public ProjectionDefinitionConfiguration projectionConfiguration()
    {
        return delegate.projectionConfiguration();
    }

    public MetadataConfiguration metadataConfiguration()
    {
        return delegate.metadataConfiguration();
    }

    public RepositoryRestConfiguration setEnableEnumTranslation( boolean enableEnumTranslation )
    {
        return delegate.setEnableEnumTranslation( enableEnumTranslation );
    }

    public RepositoryRestConfiguration setRepositoryDetectionStrategy(
            RepositoryDetectionStrategy repositoryDetectionStrategy )
    {
        return delegate.setRepositoryDetectionStrategy( repositoryDetectionStrategy );
    }

    public boolean isLookupType( Class<?> type )
    {
        return delegate.isLookupType( type );
    }

    public void setRelProvider( RelProvider relProvider )
    {
        delegate.setRelProvider( relProvider );
    }

    public EntityLookupRegistrar withEntityLookup()
    {
        return delegate.withEntityLookup();
    }

}
