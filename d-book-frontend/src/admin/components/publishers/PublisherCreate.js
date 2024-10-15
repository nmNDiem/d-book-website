import React from 'react';
import { Create, Edit, SimpleForm, TextInput } from 'react-admin';

const PublisherCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Create>
);

export default PublisherCreate;