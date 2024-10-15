import React from 'react';
import { Edit, SimpleForm, TextInput } from 'react-admin';

const PublisherEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);

export default PublisherEdit;