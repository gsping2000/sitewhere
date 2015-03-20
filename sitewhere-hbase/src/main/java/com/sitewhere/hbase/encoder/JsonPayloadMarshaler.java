/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.hbase.encoder;

import com.sitewhere.common.MarshalUtils;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceAssignmentState;
import com.sitewhere.rest.model.device.DeviceSpecification;
import com.sitewhere.rest.model.device.Site;
import com.sitewhere.rest.model.device.Zone;
import com.sitewhere.rest.model.device.batch.BatchElement;
import com.sitewhere.rest.model.device.batch.BatchOperation;
import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.event.DeviceAlert;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;
import com.sitewhere.rest.model.device.event.DeviceCommandResponse;
import com.sitewhere.rest.model.device.event.DeviceLocation;
import com.sitewhere.rest.model.device.event.DeviceMeasurements;
import com.sitewhere.rest.model.device.event.DeviceStateChange;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.group.DeviceGroupElement;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDevice;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.IDeviceAssignmentState;
import com.sitewhere.spi.device.IDeviceSpecification;
import com.sitewhere.spi.device.ISite;
import com.sitewhere.spi.device.IZone;
import com.sitewhere.spi.device.batch.IBatchElement;
import com.sitewhere.spi.device.batch.IBatchOperation;
import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;
import com.sitewhere.spi.device.event.IDeviceCommandResponse;
import com.sitewhere.spi.device.event.IDeviceLocation;
import com.sitewhere.spi.device.event.IDeviceMeasurements;
import com.sitewhere.spi.device.event.IDeviceStateChange;
import com.sitewhere.spi.device.group.IDeviceGroup;
import com.sitewhere.spi.device.group.IDeviceGroupElement;
import com.sitewhere.spi.user.IGrantedAuthority;
import com.sitewhere.spi.user.IUser;

/**
 * Implementation of {@link IPayloadMarshaler} that marshals objects to JSON.
 * 
 * @author Derek
 */
public class JsonPayloadMarshaler implements IPayloadMarshaler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#getEncoding()
	 */
	@Override
	public PayloadEncoding getEncoding() throws SiteWhereException {
		return PayloadEncoding.Json;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#encode(java.lang.Object)
	 */
	@Override
	public byte[] encode(Object obj) throws SiteWhereException {
		return MarshalUtils.marshalJson(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decode(byte[], java.lang.Class)
	 */
	@Override
	public <T> T decode(byte[] payload, Class<T> type) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeSite(com.sitewhere.spi.device
	 * .ISite)
	 */
	@Override
	public byte[] encodeSite(ISite site) throws SiteWhereException {
		return MarshalUtils.marshalJson(site);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeSite(byte[])
	 */
	@Override
	public Site decodeSite(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, Site.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeZone(com.sitewhere.spi.device
	 * .IZone)
	 */
	@Override
	public byte[] encodeZone(IZone zone) throws SiteWhereException {
		return MarshalUtils.marshalJson(zone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeZone(byte[])
	 */
	@Override
	public Zone decodeZone(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, Zone.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceSpecification(com.sitewhere
	 * .spi.device.IDeviceSpecification)
	 */
	@Override
	public byte[] encodeDeviceSpecification(IDeviceSpecification specification) throws SiteWhereException {
		return MarshalUtils.marshalJson(specification);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceSpecification(byte[])
	 */
	@Override
	public DeviceSpecification decodeDeviceSpecification(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceSpecification.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDevice(com.sitewhere.spi.device
	 * .IDevice)
	 */
	@Override
	public byte[] encodeDevice(IDevice device) throws SiteWhereException {
		return MarshalUtils.marshalJson(device);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDevice(byte[])
	 */
	@Override
	public Device decodeDevice(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, Device.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceAssignment(com.sitewhere
	 * .spi.device.IDeviceAssignment)
	 */
	@Override
	public byte[] encodeDeviceAssignment(IDeviceAssignment assignment) throws SiteWhereException {
		return MarshalUtils.marshalJson(assignment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceAssignment(byte[])
	 */
	@Override
	public DeviceAssignment decodeDeviceAssignment(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceAssignment.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceAssignmentState(com.sitewhere
	 * .spi.device.IDeviceAssignmentState)
	 */
	@Override
	public byte[] encodeDeviceAssignmentState(IDeviceAssignmentState state) throws SiteWhereException {
		return MarshalUtils.marshalJson(state);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceAssignmentState(byte[])
	 */
	@Override
	public DeviceAssignmentState decodeDeviceAssignmentState(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceAssignmentState.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceMeasurements(com.sitewhere
	 * .spi.device.event.IDeviceMeasurements)
	 */
	@Override
	public byte[] encodeDeviceMeasurements(IDeviceMeasurements measurements) throws SiteWhereException {
		return MarshalUtils.marshalJson(measurements);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceMeasurements(byte[])
	 */
	@Override
	public DeviceMeasurements decodeDeviceMeasurements(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceMeasurements.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceLocation(com.sitewhere
	 * .spi.device.event.IDeviceLocation)
	 */
	@Override
	public byte[] encodeDeviceLocation(IDeviceLocation location) throws SiteWhereException {
		return MarshalUtils.marshalJson(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceLocation(byte[])
	 */
	@Override
	public DeviceLocation decodeDeviceLocation(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceLocation.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceAlert(com.sitewhere.spi
	 * .device.event.IDeviceAlert)
	 */
	@Override
	public byte[] encodeDeviceAlert(IDeviceAlert alert) throws SiteWhereException {
		return MarshalUtils.marshalJson(alert);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceAlert(byte[])
	 */
	@Override
	public DeviceAlert decodeDeviceAlert(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceAlert.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceCommandInvocation(com
	 * .sitewhere.spi.device.event.IDeviceCommandInvocation)
	 */
	@Override
	public byte[] encodeDeviceCommandInvocation(IDeviceCommandInvocation invocation)
			throws SiteWhereException {
		return MarshalUtils.marshalJson(invocation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceCommandInvocation(byte[])
	 */
	@Override
	public DeviceCommandInvocation decodeDeviceCommandInvocation(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceCommandInvocation.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceStateChange(com.sitewhere
	 * .spi.device.event.IDeviceStateChange)
	 */
	@Override
	public byte[] encodeDeviceStateChange(IDeviceStateChange change) throws SiteWhereException {
		return MarshalUtils.marshalJson(change);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceStateChange(byte[])
	 */
	@Override
	public DeviceStateChange decodeDeviceStateChange(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceStateChange.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceCommandResponse(com.sitewhere
	 * .spi.device.event.IDeviceCommandResponse)
	 */
	@Override
	public byte[] encodeDeviceCommandResponse(IDeviceCommandResponse response) throws SiteWhereException {
		return MarshalUtils.marshalJson(response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceCommandResponse(byte[])
	 */
	@Override
	public DeviceCommandResponse decodeDeviceCommandResponse(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceCommandResponse.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeBatchOperation(com.sitewhere
	 * .spi.device.batch.IBatchOperation)
	 */
	@Override
	public byte[] encodeBatchOperation(IBatchOperation operation) throws SiteWhereException {
		return MarshalUtils.marshalJson(operation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeBatchOperation(byte[])
	 */
	@Override
	public BatchOperation decodeBatchOperation(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, BatchOperation.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeBatchElement(com.sitewhere.
	 * spi.device.batch.IBatchElement)
	 */
	@Override
	public byte[] encodeBatchElement(IBatchElement element) throws SiteWhereException {
		return MarshalUtils.marshalJson(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeBatchElement(byte[])
	 */
	@Override
	public BatchElement decodeBatchElement(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, BatchElement.class);
	}

	/* (non-Javadoc)
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceGroup(com.sitewhere.spi.device.group.IDeviceGroup)
	 */
	@Override
	public byte[] encodeDeviceGroup(IDeviceGroup group) throws SiteWhereException {
		return MarshalUtils.marshalJson(group);
	}

	/* (non-Javadoc)
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceGroup(byte[])
	 */
	@Override
	public DeviceGroup decodeDeviceGroup(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceGroup.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceGroupElement(com.sitewhere
	 * .spi.device.group.IDeviceGroupElement)
	 */
	@Override
	public byte[] encodeDeviceGroupElement(IDeviceGroupElement element) throws SiteWhereException {
		return MarshalUtils.marshalJson(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceGroupElement(byte[])
	 */
	@Override
	public DeviceGroupElement decodeDeviceGroupElement(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceGroupElement.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeDeviceCommand(com.sitewhere
	 * .spi.device.command.IDeviceCommand)
	 */
	@Override
	public byte[] encodeDeviceCommand(IDeviceCommand command) throws SiteWhereException {
		return MarshalUtils.marshalJson(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeDeviceCommand(byte[])
	 */
	@Override
	public DeviceCommand decodeDeviceCommand(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, DeviceCommand.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeUser(com.sitewhere.spi.user
	 * .IUser)
	 */
	@Override
	public byte[] encodeUser(IUser user) throws SiteWhereException {
		return MarshalUtils.marshalJson(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeUser(byte[])
	 */
	@Override
	public User decodeUser(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, User.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.hbase.encoder.IPayloadMarshaler#encodeGrantedAuthority(com.sitewhere
	 * .spi.user.IGrantedAuthority)
	 */
	@Override
	public byte[] encodeGrantedAuthority(IGrantedAuthority auth) throws SiteWhereException {
		return MarshalUtils.marshalJson(auth);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.hbase.encoder.IPayloadMarshaler#decodeGrantedAuthority(byte[])
	 */
	@Override
	public GrantedAuthority decodeGrantedAuthority(byte[] payload) throws SiteWhereException {
		return MarshalUtils.unmarshalJson(payload, GrantedAuthority.class);
	}
}