package hu.neuron.java.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;
//
// Here are the dbcp-specific classes.
// Note that they are only used in the setupDataSource
// method. In normal use, your classes interact
// only with the standard JDBC API
//

public class PoolingDataSourceExample {

	private static PoolingDataSource<PoolableConnection> dataSource;
	private static GenericObjectPool<PoolableConnection> connectionPool;
	private static Properties properties = null;

	public static synchronized PoolingDataSource<PoolableConnection> getDataSource() {
		if (dataSource == null) {
			dataSource = setupDataSource();
		}
		return dataSource;
	}

	private static PoolingDataSource<PoolableConnection> setupDataSource() {
		//
		// First, we'll create a ConnectionFactory that the
		// pool will use to create Connections.
		// We'll use the DriverManagerConnectionFactory,
		// using the connect string passed in the command line
		// arguments.
		//

		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		//
		// Next we'll create the PoolableConnectionFactory, which wraps
		// the "real" Connections created by the ConnectionFactory with
		// the classes that implement the pooling functionality.
		//
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
		connectionPool = new GenericObjectPool<>(poolableConnectionFactory);

		connectionPool.setMaxTotal(200);
		connectionPool.setMinIdle(100);
		// Set the factory's pool property to the owning pool
		poolableConnectionFactory.setPool(connectionPool);

		//
		// Finally, we create the PoolingDriver itself,
		// passing in the object pool we created.
		//
		PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);

		return dataSource;
	}

	public static void prinStats() {

		System.out.println("NumActive: " + connectionPool.getNumActive());
		System.out.println("NumIdle: " + connectionPool.getNumIdle());
	}

	public static void shutdownDataSource() throws SQLException {
		PoolingDataSource<PoolableConnection> bds = (PoolingDataSource<PoolableConnection>) dataSource;
		try {
			bds.close();
			connectionPool.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}